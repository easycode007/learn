package com.example.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World")String name) {
        model.addAttribute("name", name);
        return "hello";
    }
	
	@RequestMapping("/")
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
}
