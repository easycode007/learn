package com.mov.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MovieDao extends CrudRepository<Movie, Long>  {

	public List<Movie> findByName(String name);

}
