package com.mov.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@DiscriminatorValue("simpleMovie")
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleMovie extends Movie {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
