package com.meli.management.model.external.response.restcountries;

import lombok.Data;

import java.io.Serializable;

@Data
public class Translations implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    private String de;
    private String es;
    private String fr;
    private String ja;
    private String it;
    private String br;
    private String pt;
    private String nl;
    private String hr;
    private String fa;
}
