package com.mov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mov.model.Movie;
import com.mov.model.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	
	
	/// comentat RequestMethod.POST pentru a putea face debug in browser
	@RequestMapping(value="/movie"/*, method = RequestMethod.POST*/)
	public String addMovie(Model m, String name, String genre) {
		try {
//			Movie movie = new Movie(name, genre, releaseDate, description);
			Movie movie = new Movie(name, genre);
			movieDao.save(movie);
		} catch (Exception e) {
			m.addAttribute("error", e.toString());
			return "error";
		}
		m.addAttribute("name", name);
		m.addAttribute("genre", genre);
		return "success";
	}
	
	@RequestMapping("/list")
	public @ResponseBody Iterable listMovies() {
		Iterable<Movie> movies = movieDao.findAll();	
		return movies;
	}
	
	// comentat RequestMethod.GET pentru a putea face debug in browser
	@RequestMapping(value = "/movie/{id}"/*, method = RequestMethod.GET*/) 
	public String getMovie(Model model, @PathVariable("id") long id) {
		Movie movie = movieDao.findOne(id);
		String movieName = movie.getName();
		String movieGenre = movie.getGenre();
		System.out.println("----> " + movieName + " : " + movieGenre);
		model.addAttribute("name", movieName);
		model.addAttribute("genre", movieGenre);
		return "movie";
	}
}
