package org.acme.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DataPayload {

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;
    
}
