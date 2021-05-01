package com.meli.management.service.impl;

import com.meli.management.exception.PetitionerException;
import com.meli.management.service.api.PetitionerService;
import com.meli.management.util.BusinessMessage;
import com.meli.management.util.Constants;
import com.meli.management.util.Util;
import com.squareup.moshi.Moshi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

@Service
@Transactional
public class PetitionerServiceImpl implements PetitionerService {

        @Autowired
        private WebClient getWebClientBuilderBuild;

        @Autowired
        private Moshi getMoshiBuilder;

        private static final Logger LOGGER = LoggerFactory.getLogger(PetitionerServiceImpl.class);


        public <T,U> T getForEntity(String url, List<String> urlParam, Class<U> requestType, U request, Class<T> responseType,HttpMethod httpMethod)
                throws RestClientResponseException,PetitionerException{

            T finalObject;
            try {
                url = Util.addParameterUrl(url, request);
            } catch (URISyntaxException | UnsupportedEncodingException e) {
                LOGGER.error(BusinessMessage.ERROR_PETITIONER_URL);
                return null;
            }
            try {
                finalObject = getWebClientBuilderBuild.method(httpMethod).uri(Util.addParametersToUrl(url,urlParam)).retrieve().bodyToMono(responseType).block();
            } catch (RestClientResponseException e) {
                LOGGER.error("RestClientResponseException **", e);
                throw e;
            } catch (Exception e) {
                LOGGER.error("Exception **", e);
                throw e;
            }
            if (finalObject != null) {
                printStackTraceRequestOrResponse(requestType,request, Constants.REQUEST_WORD);
                printStackTraceRequestOrResponse(responseType,finalObject,Constants.RESPONSE_WORD);
                return finalObject;
            } else {
                LOGGER.error("getForEntity");
                throw new PetitionerException(BusinessMessage.ERROR_PETITIONER_BODY);
            }
        }


        private <T> void printStackTraceRequestOrResponse(Class<T> requestOrResponseType,T requestOrResponseObj,String requestOrResponse){
            if(requestOrResponseType!=null){
                LOGGER.debug(requestOrResponse);
                LOGGER.debug(getMoshiBuilder.adapter(requestOrResponseType).toJson(requestOrResponseObj));
            }
        }

    }
