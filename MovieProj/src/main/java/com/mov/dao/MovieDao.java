package com.mov.dao;

import com.mov.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public interface MovieDao extends CrudRepository<Movie, Long>  {

	public List<Movie> findByTitle(String title);

}
