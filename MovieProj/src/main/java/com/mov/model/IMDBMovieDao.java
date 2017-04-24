package com.mov.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rastan on 4/24/2017.
 */
@Transactional
public interface IMDBMovieDao extends CrudRepository<MovieIMDB, Long> {

}
