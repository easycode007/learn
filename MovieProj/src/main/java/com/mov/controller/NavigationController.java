package com.mov.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class NavigationController {
	private Log log  = LogFactory.getLog(this.getClass());

	@RequestMapping(value="/")
	public ModelAndView home(Model model) {
		InetAddress addr;
		String hostName = "UNDEFINED";
	    try {
			addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			model.addAttribute("msg", e.getStackTrace());
			return new ModelAndView("error");
		}
		model.addAttribute("name", hostName);
		return new ModelAndView("home");
	}

	// value = "/contactus" is linked to <definition name="home" extends="base-definition"> from tiles.xml
	@RequestMapping(value="/contactus", method = RequestMethod.GET)
	public ModelAndView contactUS() {
		return new ModelAndView("contactus");
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {
		return new ModelAndView("error");
	}
}