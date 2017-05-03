package com.mov.controller;

import com.mov.model.IMDBMovieDao;
import com.mov.model.MovieIMDB;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rastan on 4/24/2017.
 */
@Controller
public class IMDBMovieController {
    private Log log  = LogFactory.getLog(this.getClass());

    @Autowired
    private IMDBMovieDao imdbMovieDao;


    private List<String> movieTitles;


}
