package com.mov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Razvan on 08.04.2017.
 */
@Entity
@Table(name = "imdbmovies")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieIMDB implements Serializable {

    // An auto generated id (unique for each user in the db)
    @Id
    @Getter	@Setter	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter @Setter @JsonProperty("Title")
    private String title; // "Logan"
    @Getter @Setter @JsonProperty("Year")
    private String year; // "2017"
    @Getter @Setter @JsonProperty("Rated")
    private String rated; // "R"
    @Getter @Setter @JsonProperty("Released")
    private String released; // "03 Mar 2017"
    @Getter @Setter @JsonProperty("Runtime")
    private String runtime; // 137 min
    @Getter @Setter @JsonProperty("Genre")
    private String genre; // "Action, Drama, Sci-Fi"
    @Getter @Setter @JsonProperty("Director")
    private String director; // "James Mangold"
    @Getter @Setter @JsonProperty("Writer")
    private String writer; //  "James Mangold (story by), Scott Frank (screenplay), James Mangold (screenplay), Michael Green (screenplay)"
    @Getter @Setter @JsonProperty("Actors")
    private String actors; // "Hugh Jackman, Patrick Stewart, Dafne Keen, Boyd Holbrook"
    @Getter @Setter @JsonProperty("Plot")
    private String plot; // In the near future, a weary Logan cares for an ailing Professor X ...
    @Getter @Setter @JsonProperty("Country")
    private String country; // "USA"
    @Getter @Setter @JsonProperty("Awards")
    private String awards; // "N/A"
    @Getter @Setter @JsonProperty("Poster")
    private String poster; // "https://images-na.ssl-images-amazon.com/images/M/MV5BMjI1MjkzMjczMV5BMl5BanBnXkFtZTgwNDk4NjYyMTI@._V1_SX300.jpg"

    @Getter @Setter @JsonProperty("Metascore")
    private String metascore; // "77"
    @Getter @Setter @JsonProperty("imdbRating")
    private String imdbRating; // "8.5"
    @Getter @Setter @JsonProperty("imdbVotes")
    private String imdbVotes; // "181,361"
    @Getter @Setter @JsonProperty("imdbID")
    private String imdbID; // "tt3315342"
    @Getter @Setter @JsonProperty("Type")
    private String type; // "movie"
    @Getter @Setter @JsonProperty("DVD")
    private String dvd; // "N/A"
    @Getter @Setter @JsonProperty("BoxOffice")
    private String boxOffice; // "$211,775,721.00"
    @Getter @Setter @JsonProperty("Production")
    private String production; // "20th Century Fox"
    @Getter @Setter @JsonProperty("Website")
    private String website; // "http://www.foxmovies.com/movies/logan"
    @Getter @Setter @JsonProperty("votes")
    private String votes;
    @Getter @Setter @JsonProperty("Language")
    private String language; // "English, Spanish"

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
