package com.meli.management.service;

import com.meli.management.model.external.response.currency.FixerCurrencyInfResponse;
import com.meli.management.model.external.response.ip2country.IpToCountryResponse;
import com.meli.management.model.external.response.restcountries.RestCountriesResponse;
import com.meli.management.service.api.CountryService;
import com.meli.management.service.api.CurrencyService;
import com.meli.management.service.api.IpInformationService;
import com.meli.management.service.impl.BlackListIpServiceImpl;
import com.meli.management.service.impl.UserInformationServiceImpl;
import com.meli.management.util.ConstantsTest;
import com.squareup.moshi.Moshi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserInformationServiceTest {


    @InjectMocks
    private UserInformationServiceImpl userInformationService;
    @Mock
    private BlackListIpServiceImpl blackListIpService;

    private final Moshi moshi = new Moshi.Builder().build();

    @Mock
    private IpInformationService ipInformationService;
    @Mock
    private CountryService countryService;
    @Mock
    private CurrencyService currencyService;

    @Test
    void getUserInformationIpIsNotInBlackList() throws IOException {
        when(blackListIpService.isIpInBlackList(anyString())).thenReturn(Boolean.FALSE);
        when(ipInformationService.callIpToCountryApi(anyString())).thenReturn(java.util.Optional.ofNullable(moshi.adapter(IpToCountryResponse.class).fromJson(ConstantsTest.JSON_IP_INF)));
        when(countryService.callRestCountry(anyString())).thenReturn(java.util.Optional.ofNullable(moshi.adapter(RestCountriesResponse.class).fromJson(ConstantsTest.JSON_COUNTRY_INF)));
        when(currencyService.callCurrencyInf()).thenReturn(java.util.Optional.ofNullable(moshi.adapter(FixerCurrencyInfResponse.class).fromJson(ConstantsTest.JSON_CURRENCY)));
        Assertions.assertNotNull(blackListIpService.isIpInBlackList(ConstantsTest.ANY_IP));
        Assertions.assertNotNull(ipInformationService.callIpToCountryApi(ConstantsTest.ANY_IP));
        Assertions.assertNotNull(countryService.callRestCountry(ConstantsTest.ANY_COUNTRY_CODE));
        Assertions.assertNotNull(currencyService.callCurrencyInf());
        verify(blackListIpService).isIpInBlackList(anyString());
        verify(ipInformationService).callIpToCountryApi(anyString());
        verify(countryService).callRestCountry(anyString());
        verify(currencyService).callCurrencyInf();
        Assertions.assertNotNull(userInformationService.getUserInformation(anyString()));
    }


}
