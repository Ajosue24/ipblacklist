package com.meli.management.service.impl;

import com.meli.management.component.IpManagementComponent;
import com.meli.management.exception.PetitionerException;
import com.meli.management.model.external.request.OnlyAccessKeyRequest;
import com.meli.management.model.external.response.currency.FixerCurrencyInfResponse;
import com.meli.management.repository.api.RedisCommunicationService;
import com.meli.management.service.api.CurrencyService;
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
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    @Autowired
    private PetitionerService petitioner;

    @Autowired
    private RedisCommunicationService redisCommunicationService;

    @Autowired
    private IpManagementComponent ipManagementComponent;

    @Override
    public Optional<FixerCurrencyInfResponse> callCurrencyInf() {
        Optional<FixerCurrencyInfResponse> fixerCurrencyInfResponse = Optional.empty();
        try {
            Object obj = redisCommunicationService.getInRedisOnlyMono(Constants.CURRENCY_KEY_REDIS, LocalDate.now().toString());
            if(obj!=null){
                return Optional.ofNullable(ObjectMapperUtils.map(obj,new FixerCurrencyInfResponse()));
            }
            fixerCurrencyInfResponse = Optional.ofNullable(petitioner.getForEntity(ipManagementComponent.getExternalApiCurrencyInfUrl(),null, OnlyAccessKeyRequest.class, new OnlyAccessKeyRequest(ipManagementComponent.getExternalApiCurrencyInfAccessKey()), FixerCurrencyInfResponse.class, HttpMethod.GET));
            if(fixerCurrencyInfResponse.isPresent()){
                redisCommunicationService.saveInRedisThingsOnlyMono(Constants.CURRENCY_KEY_REDIS,LocalDate.now().toString(),fixerCurrencyInfResponse.get());
            }
        } catch (IOException | PetitionerException e) {
            LOGGER.error("Error getting currency", e);
        } catch (Exception e) {
            LOGGER.error("callCurrencyInf ", e);
            redisCommunicationService.deleteRedisByKeyAndId(Constants.CURRENCY_KEY_REDIS,LocalDate.now().toString());
        }
        return fixerCurrencyInfResponse;
    }

}
