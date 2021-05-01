package com.meli.management.model.external.response.restcountries;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RegionalBloc implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private String acronym;
    private String name;
    private List<Object> otherAcronyms;
    private List<String> otherNames;
}
