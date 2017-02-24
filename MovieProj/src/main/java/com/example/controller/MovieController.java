package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Movie;
import com.example.model.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	
	
	@RequestMapping("/add")
//	@ResponseBody
	public String addMovie(Model m, String name, String genre) {
		try {
//			Movie movie = new Movie(name, genre, releaseDate, description);
			Movie movie = new Movie(name, genre);
			movieDao.save(movie);
		} catch (Exception e) {
			m.addAttribute("error", e.toString());
			return "error";
		}
//		Map<String, Object> attributes = new HashMap<>();
//		attributes.put("name", name);
//		attributes.put("genre", genre);
//		attributes.put("releaseDate", releaseDate);
//		attributes.put("description", description);
		m.addAttribute("name", name);
		m.addAttribute("genre", genre);
//		m.addAttribute("releaseDate", releaseDate);
//		m.addAttribute("description", description);
		return "success";
	}
	
	@RequestMapping("/list")
	public @ResponseBody Iterable listMovies() {
		Iterable<Movie> movies = movieDao.findAll();	
		return movies;
	}
}
