package com.meli.management.model.external.response.ip2country;


import com.meli.management.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * TODO:update var names
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(Constants.IP_KEY_REDIS)
public class IpToCountryResponse implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    public String ip;
    public String type;
    public String continent_code;
    public String continent_name;
    public String country_code;
    public String country_name;
    public String region_code;
    public String region_name;
    public String city;
    public String zip;
    public double latitude;
    public double longitude;
    public Location location;
}
