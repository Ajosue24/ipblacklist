package com.meli.management.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.InetAddresses;
import com.meli.management.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    /**
     * Add parameter url
     * @param url
     * @param request
     * @return
     * @throws URISyntaxException
     * @throws UnsupportedEncodingException
     */
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

    /**
     * changue {var} to Element in list examp
     * www.algo.com/{element}/{lement} will be change whit www.algo.com/1/2
     * @param originalUrl
     * @param stringList
     * @return
     */
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

    /**
     * Gets the client IP.
     *
     * @param pRequest the request
     * @return the client IP
     */
    public static String getClientIP(HttpServletRequest pRequest) {
        String ip = null;
        if (pRequest != null) {
            if (pRequest.getHeader("x-forwarded-for") != null) {
                ip = pRequest.getHeader("x-forwarded-for");
            } else {
                ip = pRequest.getRemoteAddr();
            }
        }
        if (ip != null && ip.contains(",")) {
            String[] ips = ip.split(",");
            for (String pip : ips) {
                StringBuilder sb = new StringBuilder(pip.trim());
                if (!Constants.LOCALHOST_IP.equals(sb.toString())) {
                    ip = sb.toString();
                    break;
                }
            }
            if (ip.contains(",")) {
                ip = Constants.LOCALHOST_IP;
            }
        }
        if (ip != null && ip.length() > 15) {
            ip = "";
        }
        return ip;
    }

    /**
     * Concatenate 4 numbers in IPv4 format.
     *
     * @param octet1 Octet 1
     * @param octet2 Octet 2
     * @param octet3 Octet 3
     * @param octet4 Octet 4
     * @return IPv4 formatted string
     */
    public static String generateIPv4(int octet1, int octet2, int octet3, int octet4) {
        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }



    private Util() {
        throw new UnsupportedOperationException();
    }
}
