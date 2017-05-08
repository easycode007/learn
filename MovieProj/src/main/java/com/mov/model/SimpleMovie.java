package com.mov.model;

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
public class SimpleMovie extends Movie {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
