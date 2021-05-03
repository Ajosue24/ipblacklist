package com.meli.management.util;

import static com.meli.management.util.Util.generateIPv4;

public class Constants {
    public static final String REQUEST_WORD = "--Request--";
    public static final String RESPONSE_WORD = "--Response--";
    public static final String LEFT_CURLY_BRACE = "{";
    public static final String RIGHT_CURLY_BRACE = "}";
    public static final String IP_KEY_REDIS = "ipAddress";
    public static final String COUNTRY_KEY_REDIS = "country";
    public static final String CURRENCY_KEY_REDIS = "currency";
    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";
    public static final String LOCALHOST_IP = generateIPv4(127, 0, 0, 1);
    public static final String MESSAGE_IP_DOES_NOT_EXIST = "ip blocked or doesn't exist";


    private Constants() {
        throw new UnsupportedOperationException();
    }
}
