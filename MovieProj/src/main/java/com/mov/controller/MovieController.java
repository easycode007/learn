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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mov.model.Movie;
import com.mov.model.MovieDao;

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
		return new ModelAndView("movieView");
	}
	
	@RequestMapping(value="/movie", method = RequestMethod.GET)
	public ModelAndView showForm() {
		log.info("I am in showForm() method!!!");
		return new ModelAndView("movie", "movie", new Movie()); // view | model | obiectul din model
	}

	
	@RequestMapping("/list")
	public @ResponseBody Iterable listMovies() {
		Iterable<Movie> movies = movieDao.findAll();	
		return movies;
	}
	
	// comentat RequestMethod.GET pentru a putea face debug in browser
	@RequestMapping(value = "/movie/{id}"/*, method = RequestMethod.GET*/) 
	public ModelAndView getMovie(Model model, @PathVariable("id") long id) {
		Movie movie = movieDao.findOne(id);
		String movieName = movie.getName();
		String movieGenre = movie.getGenre();
		System.out.println("----> " + movieName + " : " + movieGenre);
		model.addAttribute("name", movieName);
		model.addAttribute("genre", movieGenre);
		return new ModelAndView("movie");
	}
}
