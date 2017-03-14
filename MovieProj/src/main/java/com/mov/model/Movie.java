package com.mov.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;

@Entity
@Table(name = "movies")
public class Movie {
	
	// An auto generated id (unique for each user in the db)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	  
	@NotNull
	@Getter
	@Setter
	private String name;
	@NotNull
	@Getter
	@Setter
	private String genre;

	public Movie() { }
	
	public Movie(long id) {
		this.id = id;
	}
	
	public Movie(String name, String genre) {
		this.name = name;
		this.genre = genre;
	}
}
