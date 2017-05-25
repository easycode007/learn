package com.bet.BetApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rastan on 5/25/2017.
 */
@Controller
public class PagesController {

    @RequestMapping(value="/")
    public ModelAndView homePage(Model model) {
        return new ModelAndView("home");
    }
}
