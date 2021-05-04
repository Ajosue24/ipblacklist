package com.meli.management.service;

import com.meli.management.component.IpManagementComponent;
import com.meli.management.model.external.request.OnlyAccessKeyRequest;
import com.meli.management.model.external.response.restcountries.RestCountriesResponse;
import com.meli.management.repository.api.RedisCommunicationService;
import com.meli.management.service.api.PetitionerService;
import com.meli.management.service.impl.CountryServiceImpl;
import com.meli.management.util.ConstantsTest;
import com.squareup.moshi.Moshi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class CountryServiceTest {

    @InjectMocks
    private CountryServiceImpl countryService;

    private final Moshi moshi = new Moshi.Builder().build();

    @Mock
    private RedisCommunicationService redisCommunicationService;

    @Mock
    private IpManagementComponent ipManagementComponent;

    @Mock
    private PetitionerService petitioner;


    @Test
    public void getCountryFromRedis() throws IOException {
        Object countryResponse = moshi.adapter(RestCountriesResponse.class).fromJson(ConstantsTest.JSON_COUNTRY_INF);
        when(redisCommunicationService.getInRedisOnlyMono(anyString(), anyString())).thenReturn(countryResponse);
        Assertions.assertNotNull(countryService.callRestCountry(ConstantsTest.ANY_COUNTRY_CODE));
        verify(redisCommunicationService).getInRedisOnlyMono(anyString(), anyString());
    }

    @Test
    public void getCountryInfFromPetitioner() throws IOException {
        RestCountriesResponse countryResponse = moshi.adapter(RestCountriesResponse.class).fromJson(ConstantsTest.JSON_COUNTRY_INF);
        when(ipManagementComponent.getExternalApiCountryInfUrl()).thenReturn("");
        when(petitioner.getForEntity(anyString(), isNull(), eq(OnlyAccessKeyRequest.class), isNull(), eq(RestCountriesResponse.class), any(HttpMethod.class))).thenReturn(countryResponse);
        Assertions.assertNotNull(countryService.callRestCountry(ConstantsTest.ANY_COUNTRY_CODE));
    }


    @Test
    public void saveInRedisCountryInf() throws IOException {
        RestCountriesResponse fixerCurrencyInfResponse = moshi.adapter(RestCountriesResponse.class).fromJson(ConstantsTest.JSON_COUNTRY_INF);
        when(ipManagementComponent.getExternalApiCountryInfUrl()).thenReturn("");
        when(petitioner.getForEntity(anyString(), isNull(), eq(OnlyAccessKeyRequest.class), isNull(), eq(RestCountriesResponse.class), any(HttpMethod.class))).thenReturn(fixerCurrencyInfResponse);
        doNothing().when(redisCommunicationService).saveInRedisThingsOnlyMono(anyString(), anyString(), any(RestCountriesResponse.class));
        Assertions.assertNotNull(countryService.callRestCountry(ConstantsTest.ANY_COUNTRY_CODE));
    }


}
