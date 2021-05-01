package com.meli.management.service.api;

import com.meli.management.model.external.response.currency.FixerCurrencyInfResponse;

import java.util.Optional;

public interface CurrencyService {

    Optional<FixerCurrencyInfResponse> callCurrencyInf();
}
