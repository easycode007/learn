package com.mov.controller;

import javax.validation.Valid;

import com.mov.model.Movie;
import com.mov.model.IMDBMovie;
import com.mov.model.SimpleMovie;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.mov.model.MovieDao;
import java.util.List;

@Controller
public class MovieController {
	private Log log  = LogFactory.getLog(this.getClass());
	
	@Autowired
	private MovieDao movieDao;

	@RequestMapping(
			value = "/movie",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseBody
	public SimpleMovie addMovie(@RequestBody SimpleMovie simpleMovie) {
		if(existsInDb(simpleMovie)) {
			return null;
		}
		movieDao.save(simpleMovie);
		return simpleMovie;
	}

	public boolean existsInDb(SimpleMovie movie) {
		List<Movie> movies = (List<Movie>) movieDao.findAll();
		for(Movie m: movies) {
			if(m.getTitle().equals(movie.getTitle()) && m.getGenre().equals(movie.getGenre())) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value="/movie", method = RequestMethod.GET)
	public ModelAndView showForm() {
		log.info("I am in showForm() method!!!");
		return new ModelAndView("movie", "movie", new SimpleMovie()); // view | model | obiectul din model
	}

	
	@RequestMapping(value="/movies", method = RequestMethod.GET)
	public ModelAndView listMovies(Model model) {
	    List<Movie> movies = (List<Movie>) movieDao.findAll();
        model.addAttribute("movieList", movies);
		return new ModelAndView("movies");
	}

	@ResponseBody
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Movie deleteMovie(@PathVariable("id") long id) {
		log.info("I am in delete controller()");
		if(movieDao.exists(id)) {
			Movie simpleMovie = movieDao.findOne(id);
			log.info(simpleMovie.toString());
			movieDao.delete(id);
			return simpleMovie;
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/movie/{id}",
            method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Movie getAMovie(@PathVariable("id") long id) {
		log.info("I am in getMovie | Controller");
		if(movieDao.exists(id)) {
			Movie simpleMovie = movieDao.findOne(id);
			log.info(simpleMovie.toString());
			return simpleMovie;
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/simpleMovie",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Movie editMovie(@RequestBody SimpleMovie simpleMovie) {
		log.info("I am in editMovie | Controller");
		Movie m = movieDao.findOne(simpleMovie.getId());
		m.setTitle(simpleMovie.getTitle());
		m.setGenre(simpleMovie.getGenre());
		log.info(m);
		movieDao.save(m);
		return simpleMovie;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Valid @ModelAttribute("name")String name, BindingResult result, Model model) {
		log.info("I am in the search method functionality");
		if(result.hasErrors()) {
			model.addAttribute("msg", result.getAllErrors().toString());
			return new ModelAndView("error");
		}
		List<Movie> results = movieDao.findByTitle(name);
        model.addAttribute("movieList", results);
		return new ModelAndView("movies");
	}

	/*	// comentat RequestMethod.GET pentru a putea face debug in browser
	@RequestMapping(value = "/movie/{name}", method = RequestMethod.GET)
	public ModelAndView getMovie(Model model, @PathVariable("name") String name) {
		SimpleMovie movie = movieDao.findOne(name);
		model.addAttribute("name", movie.getName());
		model.addAttribute("genre", movie.getGenre());
		return new ModelAndView("success");
	}*/


//	// comentat RequestMethod.GET pentru a putea face debug in browser
//	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
//	public ModelAndView getMovie(Model model, @PathVariable("id") long id) {
//		SimpleMovie movie = movieDao.findOne(id);
//		model.addAttribute("name", movie.getName());
//		model.addAttribute("genre", movie.getGenre());
//		return new ModelAndView("success");
//	}


	//	@RequestMapping(
//			value = "/movie",
//			method = RequestMethod.POST,
//			produces = MediaType.APPLICATION_JSON_VALUE,
//			consumes = MediaType.APPLICATION_JSON_VALUE
//	)
//	public SimpleMovie submit(@Valid @ModelAttribute("movie")SimpleMovie movie, BindingResult result, Model model) {
//		log.info("I am in the submit form");
//		if(result.hasErrors()) {
////			model.addAttribute("msg", result.getAllErrors().toString());
//			return null;
//		}
//		try {
//			if (existsInDb(movie)) {
////				model.addAttribute("error", "This SimpleMovie exists in DB");
//				log.info("This SimpleMovie exists in DB:  ");
////				return new ModelAndView("error", "msg", "This SimpleMovie exists in DB");
//			}
//			movieDao.save(movie);
//		} catch (Exception e) {
////            model.addAttribute("error", e.toString());
//            log.info("Error when I try to add data into db:  " + e.toString());
//            return null;
//        }
////		model.addAttribute("name", movie.getName());
////		model.addAttribute("genre", movie.getGenre());
//        return movie;
//	}

	@ResponseBody
	@RequestMapping(
			value = "/imdbmovie",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public Movie addIMDBMovie(@RequestBody Movie movie) {
		log.info("Saving imdb movie | controller");
		log.info("---> MOVIE: " + movie);
		movieDao.save(movie);
		return movie;
	}


	@ResponseBody
	@RequestMapping(
			value = "/imdb",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public IMDBMovie imdbIntegration(@RequestBody JSONObject titleObj) {
		log.info("I am in imdbIntegration() | controller");
		String title = titleObj.get("title").toString();
		log.info("Title: " + title);
		RestTemplate restTemplate = new RestTemplate();
		IMDBMovie movie = restTemplate.getForObject("http://www.omdbapi.com/?t=" + title, IMDBMovie.class);
		log.info(movie.toString());
		return movie;
	}

}
