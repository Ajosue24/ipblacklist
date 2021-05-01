package com.meli.management.model.external.response.ip2country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Language implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    /**
     * can't use native is reserved word
     */
    @JsonProperty(value = "native")
    private String nat;
}