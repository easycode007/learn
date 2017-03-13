package com.mov.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {

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
	
	@RequestMapping(value="/contactus", method = RequestMethod.GET)
	public ModelAndView contactUS() {
		return new ModelAndView("contactus");
	}
}
