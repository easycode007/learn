package com.mov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
	
	// An auto generated id (unique for each user in the db)
	@Id	@Getter	@Setter	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	  
	@NotNull @Getter @Setter
	private String name;

	@NotNull @Getter @Setter
	private String genre;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
