package com.mov.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface MovieDao extends CrudRepository<Movie, Long>  {

	public Movie findByName(String name);
}
