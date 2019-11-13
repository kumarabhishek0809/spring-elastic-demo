package com.spring.elasticsearch.application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tyre {
    private String manufacture;
    @JsonProperty("diameter")
    private int size;
    private int price;

}
