package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movies")
public class Movie {
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String genre;
	@Getter
	@Setter
	private String releaseDate;
	@Getter
	@Setter
	private String shortDescription;
	
	public Movie(String name, String genre, String releaseDate, String shortDescription) {
		this.name = name;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.shortDescription = shortDescription;
	}
	
}
