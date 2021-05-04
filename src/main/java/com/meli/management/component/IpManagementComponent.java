package com.meli.management.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Component
@RefreshScope
public class IpManagementComponent {


    public static final String CRON_RESET_REDIS = "${internal.crontab-reset}";

    @Value("${external-api.geo-ip-inf.url}")
    @Getter
    private String externalApiGeoIpInfUrl;
    @Value("${external-api.geo-ip-inf.access_key}")
    @Getter
    private String externalApiGeoIpInfAccessKey;
    @Value("${external-api.currency-inf.url}")
    @Getter
    private String externalApiCurrencyInfUrl;
    @Value("${external-api.currency-inf.access_key}")
    @Getter
    private String externalApiCurrencyInfAccessKey;
    @Value("${external-api.country-inf.url}")
    @Getter
    private String externalApiCountryInfUrl;

    @Value("${spring.redis.host}")
    @Getter
    private String redisHost;
    @Value("${spring.redis.port}")
    @Getter
    private Integer redisPort;
    @Value("${spring.redis.password}")
    @Getter
    private String redisPassword;
    @Value("${spring.redis.timeout}")
    @Getter
    private String redisTimeout;


}
