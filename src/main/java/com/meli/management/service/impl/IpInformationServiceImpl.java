package com.meli.management.service.impl;

import com.meli.management.component.IpManagementComponent;
import com.meli.management.exception.PetitionerException;
import com.meli.management.model.external.request.OnlyAccessKeyRequest;
import com.meli.management.model.external.response.currency.FixerCurrencyInfResponse;
import com.meli.management.model.external.response.ip2country.IpToCountryResponse;
import com.meli.management.model.external.response.restcountries.RestCountriesResponse;
import com.meli.management.service.api.IpInformationService;
import com.meli.management.service.api.PetitionerService;
import com.meli.management.repository.api.RedisCommunicationService;
import com.meli.management.util.Constants;
import com.meli.management.util.ObjectMapperUtils;
import com.squareup.moshi.Moshi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Service
@Transactional
public class IpInformationServiceImpl implements IpInformationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IpInformationServiceImpl.class);

    @Autowired
    private PetitionerService petitioner;

    @Autowired
    private RedisCommunicationService redisCommunicationService;

    @Autowired
    private IpManagementComponent ipManagementComponent;


    @Override
    public Optional<IpToCountryResponse> callIpToCountryApi(String ip) {
        Optional<IpToCountryResponse> ipToCountryResponse = Optional.empty();
        try {
            Object obj = redisCommunicationService.getInRedisOnlyMono(Constants.IP_KEY_REDIS,ip);
            if(obj!=null){
                return Optional.ofNullable(ObjectMapperUtils.map(obj,new IpToCountryResponse()));
            }
            ipToCountryResponse = Optional.ofNullable(petitioner.getForEntity(ipManagementComponent.getExternalApiGeoIpInfUrl(), Arrays.asList(ip), OnlyAccessKeyRequest.class, new OnlyAccessKeyRequest(ipManagementComponent.getExternalApiGeoIpInfAccessKey()), IpToCountryResponse.class, HttpMethod.GET));
            if(ipToCountryResponse.isPresent()){
                redisCommunicationService.saveInRedisThingsOnlyMono(Constants.IP_KEY_REDIS,ip,ipToCountryResponse.get());
            }
        } catch (IOException | PetitionerException e) {
            LOGGER.error("Error checking ".concat(ip), e);
        } catch (Exception e) {
            LOGGER.error("Error callIpToCountryApi ", e);
            redisCommunicationService.deleteRedisByKeyAndId(Constants.IP_KEY_REDIS,ip);
        }
        return ipToCountryResponse;
    }







}
