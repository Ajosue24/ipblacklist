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
    public UserInformationDTO getUserInformation(String ip) throws BusinessException{
        UserInformationDTO userInformationDTO = null;
        LOGGER.info("Getting user inf");
            if(!blackListIpService.isIpInBlackList(ip)){
                try {
                userInformationDTO = new UserInformationDTO();
                Optional<IpToCountryResponse> ipToCountryResponse = ipInformationService.callIpToCountryApi(ip);
                Optional<String> code = ipToCountryResponse.stream().map(IpToCountryResponse::getCountry_code).filter(Objects::nonNull).findAny();
                Optional<RestCountriesResponse> restCountriesResponse = Optional.empty();
                Optional<FixerCurrencyInfResponse> fixerCurrencyInfResponse = currencyService.callCurrencyInf();
                if(ipToCountryResponse.isPresent()&&code.isPresent()){
                    restCountriesResponse  = countryService.callRestCountry(code.get());
                }
                if(restCountriesResponse.isPresent()&&fixerCurrencyInfResponse.isPresent()){
                    userInformationDTO.setCountryName(restCountriesResponse.get().getName());
                    userInformationDTO.setCountryIso(restCountriesResponse.get().getAlpha3Code());
                    userInformationDTO.setCurrencyName(restCountriesResponse.get().getCurrencies().stream().map(Currency::getCode).collect(Collectors.toSet()));
                    UserInformationDTO finalUserInformationDTO = userInformationDTO;
                    userInformationDTO.setCurrencyValue(fixerCurrencyInfResponse.get().getRates().entrySet().stream()
                            .filter(x -> finalUserInformationDTO.getCurrencyName().stream().anyMatch(name->name.equals(x.getKey())))
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
                    userInformationDTO.setCurrencyIsCompareWith(fixerCurrencyInfResponse.get().getBase());
                return userInformationDTO;
                }else{
                    LOGGER.error("Error Bussiness rules user");
                   return userInformationDTO;
                }
            }catch (Exception e){
                    LOGGER.error("Error getting user",e);
                   return userInformationDTO;
            }
        }else {
                LOGGER.error("User ip is in blacklist");
                return userInformationDTO;
            }
    }
}
