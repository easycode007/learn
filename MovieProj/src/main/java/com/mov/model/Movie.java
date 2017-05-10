package com.mov.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "movies")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
public abstract class Movie {
    // An auto generated id (unique for each user in the db)
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter @Setter @JsonProperty("Title") @Column(name = "title")
    private String title; // "Logan"

    @Getter @Setter @JsonProperty("Genre") @Column(name = "genre")
    private String genre; // "Action, Drama, Sci-Fi"
}
