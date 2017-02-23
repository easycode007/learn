package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Movie;
import com.example.model.MovieDao;

@Controller
public class MovieController {
	@Autowired
	private MovieDao movieDao;
	
	
	@RequestMapping("/add")
	@ResponseBody
	public String addMovie(String name, String genre) {
		try {
//			Movie movie = new Movie(name, genre, releaseDate, description);
			Movie movie = new Movie(name, genre);
			movieDao.save(movie);
		} catch (Exception e) {
//			m.addAttribute("error", e.toString());
			return "error";
		}
//		Map<String, Object> attributes = new HashMap<>();
//		attributes.put("name", name);
//		attributes.put("genre", genre);
//		attributes.put("releaseDate", releaseDate);
//		attributes.put("description", description);
//		m.addAttribute("name", name);
//		m.addAttribute("genre", genre);
//		m.addAttribute("releaseDate", releaseDate);
//		m.addAttribute("description", description);
		return "success";
	}
	
//	@RequestMapping("/list")
//	public void listMovies() {
//		
//	}
	
//	@RequestMapping("/error")
//	public String error() {
//		
//		return "";
//	}
}
