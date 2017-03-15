package com.mov.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mov.model.Movie;
import com.mov.model.MovieDao;

import java.util.List;

@Controller
public class MovieController {
	private Log log  = LogFactory.getLog(this.getClass());
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public ModelAndView submit(@Valid @ModelAttribute("movie")Movie movie, BindingResult result, Model model) {
		log.info("I am in the submit form");
		if(result.hasErrors()) {
			model.addAttribute("msg", result.getAllErrors().toString());
			return new ModelAndView("error");
		}
		try {
			movieDao.save(movie);
		} catch (Exception e) {
            model.addAttribute("error", e.toString());
            log.info("Error when I try to add data into db:  " + e.toString());
            return new ModelAndView("error");
        }
		model.addAttribute("name", movie.getName());
		model.addAttribute("genre", movie.getGenre());
        return new ModelAndView("success");
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
	
	// comentat RequestMethod.GET pentru a putea face debug in browser
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public ModelAndView getMovie(Model model, @PathVariable("id") long id) {
		Movie movie = movieDao.findOne(id);
		model.addAttribute("name", movie.getName());
		model.addAttribute("genre", movie.getGenre());
		return new ModelAndView("success");
	}

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchAMovie() {
        log.info("I am in search method()");
        return new ModelAndView("search");
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
}
