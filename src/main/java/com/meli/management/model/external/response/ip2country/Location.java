package com.meli.management.model.external.response.ip2country;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * TODO:update var names
 */
@Data
public class Location implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    public int geoname_id;
    public String capital;
    public List<Language> languages;
    public String country_flag;
    public String country_flag_emoji;
    public String country_flag_emoji_unicode;
    public String calling_code;
    public boolean is_eu;
}
