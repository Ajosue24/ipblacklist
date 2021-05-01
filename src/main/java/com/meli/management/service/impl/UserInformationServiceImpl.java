package com.meli.management.service.impl;

import com.meli.management.exception.BusinessException;
import com.meli.management.model.dto.UserInformationDTO;
import com.meli.management.model.external.response.currency.FixerCurrencyInfResponse;
import com.meli.management.model.external.response.ip2country.IpToCountryResponse;
import com.meli.management.model.external.response.restcountries.Currency;
import com.meli.management.model.external.response.restcountries.RestCountriesResponse;
import com.meli.management.service.api.*;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserInformationServiceImpl implements UserInformationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInformationServiceImpl.class);

    @Autowired
    private IpInformationService ipInformationService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private BlackListIpService blackListIpService;

    @Override
    public UserInformationDTO getUserInformation(String ip) {
        if(!blackListIpService.isIpInBlackList(ip)){
/*        String countryName;
        String countryIso;
        String currencyName;
        String currencyIsCompareWith;
        BigDecimal currencyValue;*/
            UserInformationDTO userInformationDTO = new UserInformationDTO();
            Optional<IpToCountryResponse> ipToCountryResponse = ipInformationService.callIpToCountryApi(ip);
            Optional<String> code = ipToCountryResponse.stream().map(IpToCountryResponse::getCountry_code).filter(Objects::nonNull).findAny();
            Optional<RestCountriesResponse> restCountriesResponse = Optional.empty();
            Optional<FixerCurrencyInfResponse> fixerCurrencyInfResponse = currencyService.callCurrencyInf();
            if(ipToCountryResponse.isPresent()&&code.isPresent()){
                restCountriesResponse  = countryService.callRestCountry(code.get());
            }
            if(restCountriesResponse.isPresent()&&fixerCurrencyInfResponse.isPresent()){
                Map<String,BigDecimal> map=new HashMap<>();
                userInformationDTO.setCountryName(restCountriesResponse.get().getName());
                userInformationDTO.setCountryIso(restCountriesResponse.get().getAlpha3Code());
                userInformationDTO.setCurrencyName(restCountriesResponse.get().getCurrencies().stream().map(Currency::getName).collect(Collectors.toSet()));
                userInformationDTO.setCurrencyIsCompareWith(fixerCurrencyInfResponse.get().getBase());
                /**
                 * TODO: map currency
                 */
            }else{
                throw new BusinessException("User data doesn't exist");
            }

        }


        return null;
    }
}
