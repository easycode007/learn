package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Movie;
import com.example.model.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	
	
	@RequestMapping("/add")
	public String addMovie(String name, String genre, 
			String releaseDate, String shortDescription) {
		try {
			Movie movie = new Movie(name, genre, releaseDate, shortDescription);
			movieDao.addMovie(movie);
		} catch (Exception e) {
			return "Error adding the movie " + e.toString();
		}
		return "Movie successfully added";
	}
	
	@RequestMapping("/list")
	public void listMovies() {
		
	}
	
//	@RequestMapping("/error")
//	public String error() {
//		
//		return "";
//	}
}
