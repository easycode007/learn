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
public class HelloController {
	private Log log  = LogFactory.getLog(this.getClass());
	
	@RequestMapping(value="/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World")String name) {
		log.info("======= Make a request to /hello");
		model.addAttribute("name", name);
        return "hello";
    }
}
