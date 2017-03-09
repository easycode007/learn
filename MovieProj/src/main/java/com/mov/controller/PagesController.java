package com.mov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

	@RequestMapping(value="/intro")
	public String introPage() {
		return "intro";		
	}
	
	@RequestMapping(value="/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value="/add")
	public String addMovies() {
		return "addMovie";
	}
}
