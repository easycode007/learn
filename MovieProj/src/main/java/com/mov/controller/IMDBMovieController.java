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

/**
 * Created by rastan on 4/24/2017.
 */
@Controller
public class IMDBMovieController {
    private Log log  = LogFactory.getLog(this.getClass());

    @Autowired
    private IMDBMovieDao imdbMovieDao;


    @ResponseBody
    @RequestMapping(
            value = "/imdbmovie",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MovieIMDB addIMDBMovie(@RequestBody MovieIMDB movie) {
        log.info("Saving imdb movie | controller");
        log.info("---> MOVIE: " + movie);
        imdbMovieDao.save(movie);
        return movie;
    }


    @ResponseBody
    @RequestMapping(
            value = "/imdb",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MovieIMDB imdbIntegration(@RequestBody JSONObject titleObj) {
        log.info("I am in imdbIntegration() | controller");
        String title = titleObj.get("title").toString();
        log.info("Title: " + title);
        RestTemplate restTemplate = new RestTemplate();
        MovieIMDB movie = restTemplate.getForObject("http://www.omdbapi.com/?t=" + title, MovieIMDB.class);
        log.info(movie.toString());
        return movie;
    }
}
