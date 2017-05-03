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
@Entity(name="MovieImdb")
@DiscriminatorValue("imdbMovie")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieIMDB implements Serializable {

//    // An auto generated id (unique for each user in the db)
//    @Id
//    @Getter	@Setter	@GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @Getter @Setter @JsonProperty("Title")
//    private String title; // "Logan"
    @Getter @Setter @JsonProperty("Year") @Column
    private String year; // "2017"
    @Getter @Setter @JsonProperty("Rated") @Column
    private String rated; // "R"
    @Getter @Setter @JsonProperty("Released") @Column
    private String released; // "03 Mar 2017"
    @Getter @Setter @JsonProperty("Runtime") @Column
    private String runtime; // 137 min
//    @Getter @Setter @JsonProperty("Genre")
//    private String genre; // "Action, Drama, Sci-Fi"
    @Getter @Setter @JsonProperty("Director") @Column
    private String director; // "James Mangold"
    @Getter @Setter @JsonProperty("Writer") @Column
    private String writer; //  "James Mangold (story by), Scott Frank (screenplay), James Mangold (screenplay), Michael Green (screenplay)"
    @Getter @Setter @JsonProperty("Actors") @Column
    private String actors; // "Hugh Jackman, Patrick Stewart, Dafne Keen, Boyd Holbrook"
    @Getter @Setter @JsonProperty("Plot") @Column
    private String plot; // In the near future, a weary Logan cares for an ailing Professor X ...
    @Getter @Setter @JsonProperty("Country") @Column
    private String country; // "USA"
    @Getter @Setter @JsonProperty("Awards") @Column
    private String awards; // "N/A"
    @Getter @Setter @JsonProperty("Poster") @Column
    private String poster; // "https://images-na.ssl-images-amazon.com/images/M/MV5BMjI1MjkzMjczMV5BMl5BanBnXkFtZTgwNDk4NjYyMTI@._V1_SX300.jpg"
    @Getter @Setter @JsonProperty("Metascore") @Column
    private String metascore; // "77"
    @Getter @Setter @JsonProperty("imdbRating") @Column
    private String imdbRating; // "8.5"
    @Getter @Setter @JsonProperty("imdbVotes") @Column
    private String imdbVotes; // "181,361"
    @Getter @Setter @JsonProperty("imdbID") @Column
    private String imdbID; // "tt3315342"
    @Getter @Setter @JsonProperty("Type") @Column
    private String type; // "movie"
    @Getter @Setter @JsonProperty("DVD") @Column
    private String dvd; // "N/A"
    @Getter @Setter @JsonProperty("BoxOffice") @Column
    private String boxOffice; // "$211,775,721.00"
    @Getter @Setter @JsonProperty("Production") @Column
    private String production; // "20th Century Fox"
    @Getter @Setter @JsonProperty("Website") @Column
    private String website; // "http://www.foxmovies.com/movies/logan"
    @Getter @Setter @JsonProperty("votes") @Column
    private String votes;
    @Getter @Setter @JsonProperty("Language") @Column
    private String language; // "English, Spanish"

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
