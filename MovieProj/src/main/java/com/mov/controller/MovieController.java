package com.mov.controller;

import javax.validation.Valid;

import com.mov.model.IMDBMovieDao;
import com.mov.model.MovieIMDB;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.mov.model.Movie;
import com.mov.model.MovieDao;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;
import static org.springframework.http.MediaType.TEXT_HTML;

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
	public Movie addMovie(@RequestBody Movie movie) {
		if(existsInDb(movie)) {
			return null;
		}
		movieDao.save(movie);
		return movie;
	}

	public boolean existsInDb(Movie movie) {
		List<Movie> movies = (List<Movie>) movieDao.findAll();
		for(Movie m: movies) {
			if(m.getName().equals(movie.getName()) && m.getGenre().equals(movie.getGenre())) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value="/movie", method = RequestMethod.GET)
	public ModelAndView showForm() {
		log.info("I am in showForm() method!!!");
		return new ModelAndView("movie", "movie", new Movie()); // view | model | obiectul din model
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
			Movie movie = movieDao.findOne(id);
			log.info(movie.toString());
			movieDao.delete(id);
			return movie;
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
			Movie movie = movieDao.findOne(id);
			log.info(movie.toString());
			return movie;
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/movie",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Movie editMovie(@RequestBody Movie movie) {
		log.info("I am in editMovie | Controller");
		Movie m = movieDao.findOne(movie.getId());
		m.setName(movie.getName());
		m.setGenre(movie.getGenre());
		log.info(m);
		movieDao.save(m);
		return movie;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@Valid @ModelAttribute("name")String name, BindingResult result, Model model) {
		log.info("I am in the search method functionality");
		if(result.hasErrors()) {
			model.addAttribute("msg", result.getAllErrors().toString());
			return new ModelAndView("error");
		}
		List<Movie> results = movieDao.findByName(name);
        model.addAttribute("movieList", results);
		return new ModelAndView("movies");
	}

	/*	// comentat RequestMethod.GET pentru a putea face debug in browser
	@RequestMapping(value = "/movie/{name}", method = RequestMethod.GET)
	public ModelAndView getMovie(Model model, @PathVariable("name") String name) {
		Movie movie = movieDao.findOne(name);
		model.addAttribute("name", movie.getName());
		model.addAttribute("genre", movie.getGenre());
		return new ModelAndView("success");
	}*/


//	// comentat RequestMethod.GET pentru a putea face debug in browser
//	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
//	public ModelAndView getMovie(Model model, @PathVariable("id") long id) {
//		Movie movie = movieDao.findOne(id);
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
//	public Movie submit(@Valid @ModelAttribute("movie")Movie movie, BindingResult result, Model model) {
//		log.info("I am in the submit form");
//		if(result.hasErrors()) {
////			model.addAttribute("msg", result.getAllErrors().toString());
//			return null;
//		}
//		try {
//			if (existsInDb(movie)) {
////				model.addAttribute("error", "This Movie exists in DB");
//				log.info("This Movie exists in DB:  ");
////				return new ModelAndView("error", "msg", "This Movie exists in DB");
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


}
