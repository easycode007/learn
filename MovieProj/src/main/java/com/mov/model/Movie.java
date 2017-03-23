package com.mov.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {
	
	// An auto generated id (unique for each user in the db)
	@Id
	@Getter
	@Setter
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
