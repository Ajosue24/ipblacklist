package com.meli.management.service.api;

import com.meli.management.model.external.response.currency.FixerCurrencyInfResponse;
import com.meli.management.model.external.response.ip2country.IpToCountryResponse;
import com.meli.management.model.external.response.restcountries.RestCountriesResponse;

import java.util.Optional;

public interface IpInformationService {

    Optional<IpToCountryResponse> callIpToCountryApi(String ip);

}
