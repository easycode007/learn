package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Movie;
import com.example.model.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	
	
	@RequestMapping("/add")
	public String addMovie(Model m, 
			@RequestParam(value="name", required=true, defaultValue="DefaultName") String name, 
			@RequestParam(value="genre", required=true, defaultValue="DefaultGenre") String genre, 
			@RequestParam(value="releaseDate", required=true, defaultValue="ReleaseDate") String releaseDate,
			@RequestParam(value="description", required=true, defaultValue="Description") String description) {
		try {
			Movie movie = new Movie(name, genre, releaseDate, description);
			movieDao.addMovie(movie);
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
		m.addAttribute("releaseDate", releaseDate);
		m.addAttribute("description", description);
		return "success";
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
