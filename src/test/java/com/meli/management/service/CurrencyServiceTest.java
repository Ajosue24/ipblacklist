package com.meli.management.service;

import com.meli.management.component.IpManagementComponent;
import com.meli.management.model.external.request.OnlyAccessKeyRequest;
import com.meli.management.model.external.response.currency.FixerCurrencyInfResponse;
import com.meli.management.repository.api.RedisCommunicationService;
import com.meli.management.service.api.PetitionerService;
import com.meli.management.service.impl.CurrencyServiceImpl;
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
public class CurrencyServiceTest {

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    private final Moshi moshi = new Moshi.Builder().build();

    @Mock
    private RedisCommunicationService redisCommunicationService;

    @Mock
    private IpManagementComponent ipManagementComponent;

    @Mock
    private PetitionerService petitioner;


    @Test
    public void getCurrencyListFromRedis() throws IOException {
        Object fixerCurrencyInfResponseTest = moshi.adapter(FixerCurrencyInfResponse.class).fromJson(ConstantsTest.JSON_CURRENCY);
        when(redisCommunicationService.getInRedisOnlyMono(anyString(), anyString())).thenReturn(fixerCurrencyInfResponseTest);
        Assertions.assertNotNull(currencyService.callCurrencyInf());
        verify(redisCommunicationService).getInRedisOnlyMono(anyString(), anyString());
    }

    @Test
    public void getCurrencyListFromPetitioner() throws IOException {
        FixerCurrencyInfResponse fixerCurrencyInfResponse = moshi.adapter(FixerCurrencyInfResponse.class).fromJson(ConstantsTest.JSON_CURRENCY);
        when(ipManagementComponent.getExternalApiCurrencyInfAccessKey()).thenReturn("");
        when(ipManagementComponent.getExternalApiCurrencyInfUrl()).thenReturn("");
        when(petitioner.getForEntity(anyString(), isNull(), eq(OnlyAccessKeyRequest.class), any(OnlyAccessKeyRequest.class), eq(FixerCurrencyInfResponse.class), any(HttpMethod.class))).thenReturn(fixerCurrencyInfResponse);
        Assertions.assertNotNull(currencyService.callCurrencyInf());
        verify(petitioner).getForEntity(anyString(), isNull(), eq(OnlyAccessKeyRequest.class), any(OnlyAccessKeyRequest.class), eq(FixerCurrencyInfResponse.class), any(HttpMethod.class));
    }


    @Test
    public void saveInRedisCurrency() throws IOException {
        FixerCurrencyInfResponse fixerCurrencyInfResponse = moshi.adapter(FixerCurrencyInfResponse.class).fromJson(ConstantsTest.JSON_CURRENCY);
        when(ipManagementComponent.getExternalApiCurrencyInfUrl()).thenReturn("");
        when(ipManagementComponent.getExternalApiCurrencyInfAccessKey()).thenReturn("");
        when(petitioner.getForEntity(anyString(), isNull(), eq(OnlyAccessKeyRequest.class), any(OnlyAccessKeyRequest.class), eq(FixerCurrencyInfResponse.class), any(HttpMethod.class))).thenReturn(fixerCurrencyInfResponse);
        doNothing().when(redisCommunicationService).saveInRedisThingsOnlyMono(anyString(), anyString(), any(FixerCurrencyInfResponse.class));
        Assertions.assertNotNull(currencyService.callCurrencyInf());
        verify(redisCommunicationService).saveInRedisThingsOnlyMono(anyString(), anyString(), any(FixerCurrencyInfResponse.class));
    }


}
