package com.mov.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mov.model.Movie;


@Controller
public class AppController {
	private Log log  = LogFactory.getLog(this.getClass());

	@RequestMapping(value="/")
	public String home(Model model) {
		InetAddress addr;
		String hostName = "UNDEFINED";
	    try {
			addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("name", hostName);
		return "home";
	}
	
	@RequestMapping(value="/movie", method = RequestMethod.GET)
	public ModelAndView showForm() {
		log.info("I am in showForm() method!!!");
		return new ModelAndView("movieForm", "movie", new Movie());
	}
	
	@RequestMapping(value="/contactus", method = RequestMethod.GET)
	public ModelAndView contactUS() {
		return new ModelAndView("contactus");
	}
}
