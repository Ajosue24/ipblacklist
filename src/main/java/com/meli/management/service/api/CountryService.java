package com.meli.management.service.api;

import com.meli.management.model.external.response.restcountries.RestCountriesResponse;

import java.util.Optional;

public interface CountryService {

    Optional<RestCountriesResponse> callRestCountry(String code);
}
