package com.mov.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Razvan on 09.04.2017.
 */
public class Rating {
    @Getter@Setter @JsonProperty("Source")
    private String source; // "Internet SimpleMovie Database"
    @Getter @Setter @JsonProperty("Value")
    private String value; // "8.5/10"
}
