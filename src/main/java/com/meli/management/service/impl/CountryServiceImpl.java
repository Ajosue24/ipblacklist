package com.meli.management.service.impl;

import com.meli.management.component.IpManagementComponent;
import com.meli.management.exception.PetitionerException;
import com.meli.management.model.external.response.restcountries.RestCountriesResponse;
import com.meli.management.repository.api.RedisCommunicationService;
import com.meli.management.service.api.CountryService;
import com.meli.management.service.api.PetitionerService;
import com.meli.management.util.Constants;
import com.meli.management.util.ObjectMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final PetitionerService petitioner;

    private final RedisCommunicationService redisCommunicationService;

    private final IpManagementComponent ipManagementComponent;

    public CountryServiceImpl(PetitionerService petitioner, RedisCommunicationService redisCommunicationService, IpManagementComponent ipManagementComponent) {
        this.petitioner = petitioner;
        this.redisCommunicationService = redisCommunicationService;
        this.ipManagementComponent = ipManagementComponent;
    }


    @Override
    public Optional<RestCountriesResponse> callRestCountry(String code) {
        Optional<RestCountriesResponse> restCountriesResponse = Optional.empty();
        try {
            Object obj = redisCommunicationService.getInRedisOnlyMono(Constants.COUNTRY_KEY_REDIS,code);
            if(obj!=null){
                return Optional.of(ObjectMapperUtils.map(obj,new RestCountriesResponse()));
            }
            restCountriesResponse = Optional.ofNullable(petitioner.getForEntity(ipManagementComponent.getExternalApiCountryInfUrl(), Arrays.asList(code), null, null, RestCountriesResponse.class, HttpMethod.GET));
            if(restCountriesResponse.isPresent()){
                redisCommunicationService.saveInRedisThingsOnlyMono(Constants.COUNTRY_KEY_REDIS,code,restCountriesResponse.get());
            }
        } catch (IOException | PetitionerException e) {
            LOGGER.error("Error checking ".concat(code), e);
        } catch (Exception e) {
            LOGGER.error("callRestCountry ", e);
            redisCommunicationService.deleteRedisByKeyAndId(Constants.COUNTRY_KEY_REDIS,code);
        }
        return restCountriesResponse;
    }
}
