package com.mov.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MovieDao extends CrudRepository<Movie, Long>  {

	public Movie findByName(String name);
}
