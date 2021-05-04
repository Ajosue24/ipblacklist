package com.meli.management.service;

import com.meli.management.component.IpManagementComponent;
import com.meli.management.model.external.request.OnlyAccessKeyRequest;
import com.meli.management.model.external.response.ip2country.IpToCountryResponse;
import com.meli.management.repository.api.RedisCommunicationService;
import com.meli.management.service.api.PetitionerService;
import com.meli.management.service.impl.IpInformationServiceImpl;
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
public class IpInformationServiceTest {

    @InjectMocks
    private IpInformationServiceImpl ipIformationService;

    private final Moshi moshi = new Moshi.Builder().build();

    @Mock
    private RedisCommunicationService redisCommunicationService;

    @Mock
    private IpManagementComponent ipManagementComponent;

    @Mock
    private PetitionerService petitioner;


    @Test
    public void getCountryFromRedis() throws IOException {
        Object ipInformationObj = moshi.adapter(IpToCountryResponse.class).fromJson(ConstantsTest.JSON_IP_INF);
        when(redisCommunicationService.getInRedisOnlyMono(anyString(), anyString())).thenReturn(ipInformationObj);
        Assertions.assertNotNull(ipIformationService.callIpToCountryApi(ConstantsTest.ANY_IP));
        verify(redisCommunicationService).getInRedisOnlyMono(anyString(), anyString());
    }

    @Test
    public void getCountryInfFromPetitioner() throws IOException {
        IpToCountryResponse ipInformationObj = moshi.adapter(IpToCountryResponse.class).fromJson(ConstantsTest.JSON_IP_INF);
        when(ipManagementComponent.getExternalApiGeoIpInfUrl()).thenReturn("");
        when(petitioner.getForEntity(anyString(), isNull(), eq(OnlyAccessKeyRequest.class), isNull(), eq(IpToCountryResponse.class), any(HttpMethod.class))).thenReturn(ipInformationObj);
        Assertions.assertNotNull(ipIformationService.callIpToCountryApi(ConstantsTest.ANY_IP));
    }


    @Test
    public void saveInRedisCountryInf() throws IOException {
        IpToCountryResponse fixerCurrencyInfResponse = moshi.adapter(IpToCountryResponse.class).fromJson(ConstantsTest.JSON_COUNTRY_INF);
        when(ipManagementComponent.getExternalApiGeoIpInfUrl()).thenReturn("");
        when(petitioner.getForEntity(anyString(), isNull(), eq(OnlyAccessKeyRequest.class), isNull(), eq(IpToCountryResponse.class), any(HttpMethod.class))).thenReturn(fixerCurrencyInfResponse);
        doNothing().when(redisCommunicationService).saveInRedisThingsOnlyMono(anyString(), anyString(), any(IpToCountryResponse.class));
        Assertions.assertNotNull(ipIformationService.callIpToCountryApi(ConstantsTest.ANY_IP));
    }

}
