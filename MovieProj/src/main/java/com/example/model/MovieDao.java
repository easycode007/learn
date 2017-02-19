package com.example.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MovieDao {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;
	
	public void addMovie(Movie movie) {
		entityManager.persist(movie);
	}
	
	public List getAllMovies() {
		return entityManager.createQuery("from Movie").getResultList();
	}
	
	public void updateMovie(Movie movie) {
		entityManager.merge(movie);
	}
	
	public Movie getByName(String name) {
		return entityManager.find(Movie.class, name);
	}
	
	public void deleteMovie(Movie movie) {
		if(entityManager.contains(movie)) {
			entityManager.remove(movie);
		} else {
			entityManager.remove(entityManager.merge(movie));
		}
	}
	
}
