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
import com.mov.dao.MovieDao;
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
		log.info("I am in addMovie() method !!!!");
//		if(existsInDb(simpleMovie)) {
//			return null;
//		}
		log.info("----------> MOVIE: " + simpleMovie);
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
		return new ModelAndView("movie", "SimpleMovie", new SimpleMovie()); // view | model | obiectul din model
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
	public SimpleMovie getAMovie(@PathVariable("id") long id) {
		log.info("I am in getMovie | Controller");
		if(movieDao.exists(id)) {
			SimpleMovie simpleMovie = (SimpleMovie)movieDao.findOne(id);
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
	public SimpleMovie editSimpleMovie(@RequestBody SimpleMovie simpleMovie) {
		log.info("I am in editMovie | Controller");
		SimpleMovie m = (SimpleMovie)movieDao.findOne(simpleMovie.getId());
		m.setTitle(simpleMovie.getTitle());
		m.setGenre(simpleMovie.getGenre());
		log.info(m);
		movieDao.save(m);
		return simpleMovie;
	}

/*	@ResponseBody
	@RequestMapping(value = "/simpleMovie",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public IMDBMovie editIMDBMovie(@RequestBody IMDBMovie imdbMovie) {
		log.info("I am in editMovie | Controller");
		SimpleMovie m = (SimpleMovie)movieDao.findOne(imdbMovie.getId());
		m.setTitle(imdbMovie.getTitle());
		m.setGenre(imdbMovie.getGenre());
		log.info(m);
		movieDao.save(m);
		return imdbMovie;
	}*/

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

	@ResponseBody
	@RequestMapping(
			value = "/imdbmovie",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public IMDBMovie addIMDBMovie(@RequestBody IMDBMovie movie) {
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
