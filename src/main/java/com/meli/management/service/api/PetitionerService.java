package com.meli.management.service.api;

import com.meli.management.exception.PetitionerException;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;

import java.io.IOException;
import java.util.List;

public interface PetitionerService {

    <T,U> T getForEntity(String url, List<String> urlParam, Class<U> requestType, U request, Class<T> responseType, HttpMethod httpMethod)
            throws RestClientResponseException, IOException, PetitionerException;

}
