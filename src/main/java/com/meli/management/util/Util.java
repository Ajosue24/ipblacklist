package com.meli.management.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    public static String addParameterUrl(String url, Object request) throws URISyntaxException, UnsupportedEncodingException {

        // Start logical for add parameters url
        url = URLEncoder.encode(url, StandardCharsets.UTF_8);
        URIBuilder urib = new URIBuilder(url);
        Map<String, String> params;
        if (request != null) {
            params = new ObjectMapper().convertValue(request, new TypeReference<>() {
            });
            params.entrySet().stream().forEach(entry -> {
                urib.addParameter(entry.getKey(), entry.getValue());
            });
        }
        LOGGER.debug("this is the url: ".concat(urib.build().toString()));
        return URLDecoder.decode(urib.build().toString(), StandardCharsets.UTF_8);
    }

    public static String addParametersToUrl(String originalUrl, List<String> stringList) {
        if (stringList != null && !stringList.isEmpty()) {
            String tempOrgUrl = originalUrl;
            var finalUrl = new Object(){ String tempString=tempOrgUrl; };
            stringList.stream().forEach(s -> {
                if (StringUtils.substringBetween(finalUrl.tempString, Constants.LEFT_CURLY_BRACE, Constants.RIGHT_CURLY_BRACE) != null) {
                    finalUrl.tempString = finalUrl.tempString.replace(Constants.LEFT_CURLY_BRACE.concat(StringUtils.substringBetween(finalUrl.tempString, Constants.LEFT_CURLY_BRACE, Constants.RIGHT_CURLY_BRACE)).concat(Constants.RIGHT_CURLY_BRACE), s);
                }
            });
            return finalUrl.tempString;
        }
        return originalUrl;
    }


    private Util() {
        throw new UnsupportedOperationException();
    }
}
