package com.meli.management.model.external.response.currency;

import com.meli.management.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(Constants.CURRENCY_KEY_REDIS)
public class FixerCurrencyInfResponse implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    private Boolean success;
    private Integer timestamp;
    private String base;
    private String date;
    private Map<String, Double> rates;
}

