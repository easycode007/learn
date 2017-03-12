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


@Controller
@RequestMapping(value="/")
public class AppController {
	
	@RequestMapping("/hello")
	public String firstPage(Model model) {
		InetAddress addr;
		String hostName = "UNDEFINED";
	    try {
			addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		model.addAttribute("myName", hostName);
		return "intro";
	}
	
	@RequestMapping(value="/")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("/contactus")
	public String contactUS() {
		return "contactus";
	}

}
