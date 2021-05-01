package com.meli.management.model.external.response.restcountries;

import lombok.Data;

import java.io.Serializable;

@Data
public class Language implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private String iso639_1;
    private String iso639_2;
    private String name;
    private String nativeName;
}
