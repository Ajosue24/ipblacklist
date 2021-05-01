package com.meli.management.model.external.response.restcountries;

import lombok.Data;

import java.io.Serializable;

@Data
public class Currency  implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    private String code;
    private String name;
    private String symbol;
}