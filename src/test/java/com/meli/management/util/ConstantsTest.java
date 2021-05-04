package com.meli.management.util;

import com.meli.management.model.external.request.OnlyAccessKeyRequest;

public class ConstantsTest {

    public static String ANY_IP = "186.80.52.15";
    public static String ANY_COUNTRY_CODE = "COL";
    public static String JSON_COUNTRY_INF = "{\n" +
            "\"name\": \"Colombia\",\n" +
            "\"topLevelDomain\": [\n" +
            "  \".co\"\n" +
            "],\n" +
            "\"alpha2Code\": \"CO\",\n" +
            "\"alpha3Code\": \"COL\",\n" +
            "\"callingCodes\": [\n" +
            "  \"57\"\n" +
            "],\n" +
            "\"capital\": \"Bogotá\",\n" +
            "\"altSpellings\": [\n" +
            "  \"CO\",\n" +
            "  \"Republic of Colombia\",\n" +
            "  \"República de Colombia\"\n" +
            "],\n" +
            "\"region\": \"Americas\",\n" +
            "\"subregion\": \"South America\",\n" +
            "\"population\": 48759958,\n" +
            "\"latlng\": [\n" +
            "  4.0,\n" +
            "  -72.0\n" +
            "],\n" +
            "\"demonym\": \"Colombian\",\n" +
            "\"area\": 1141748.0,\n" +
            "\"gini\": 55.9,\n" +
            "\"timezones\": [\n" +
            "  \"UTC-05:00\"\n" +
            "],\n" +
            "\"borders\": [\n" +
            "  \"BRA\",\n" +
            "  \"ECU\",\n" +
            "  \"PAN\",\n" +
            "  \"PER\",\n" +
            "  \"VEN\"\n" +
            "],\n" +
            "\"nativeName\": \"Colombia\",\n" +
            "\"numericCode\": \"170\",\n" +
            "\"currencies\": [\n" +
            "  {\n" +
            "    \"code\": \"COP\",\n" +
            "    \"name\": \"Colombian peso\",\n" +
            "    \"symbol\": \"$\"\n" +
            "  }\n" +
            "],\n" +
            "\"languages\": [\n" +
            "  {\n" +
            "    \"iso639_1\": \"es\",\n" +
            "    \"iso639_2\": \"spa\",\n" +
            "    \"name\": \"Spanish\",\n" +
            "    \"nativeName\": \"Español\"\n" +
            "  }\n" +
            "],\n" +
            "\"translations\": {\n" +
            "  \"de\": \"Kolumbien\",\n" +
            "  \"es\": \"Colombia\",\n" +
            "  \"fr\": \"Colombie\",\n" +
            "  \"ja\": \"コロンビア\",\n" +
            "  \"it\": \"Colombia\",\n" +
            "  \"br\": \"Colômbia\",\n" +
            "  \"pt\": \"Colômbia\",\n" +
            "  \"nl\": \"Colombia\",\n" +
            "  \"hr\": \"Kolumbija\",\n" +
            "  \"fa\": \"کلمبیا\"\n" +
            "},\n" +
            "\"flag\": \"https://restcountries.eu/data/col.svg\",\n" +
            "\"regionalBlocs\": [\n" +
            "  {\n" +
            "    \"acronym\": \"PA\",\n" +
            "    \"name\": \"Pacific Alliance\",\n" +
            "    \"otherAcronyms\": [\n" +
            "      \n" +
            "    ],\n" +
            "    \"otherNames\": [\n" +
            "      \"Alianza del Pacífico\"\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"acronym\": \"USAN\",\n" +
            "    \"name\": \"Union of South American Nations\",\n" +
            "    \"otherAcronyms\": [\n" +
            "      \"UNASUR\",\n" +
            "      \"UNASUL\",\n" +
            "      \"UZAN\"\n" +
            "    ],\n" +
            "    \"otherNames\": [\n" +
            "      \"Unión de Naciones Suramericanas\",\n" +
            "      \"União de Nações Sul-Americanas\",\n" +
            "      \"Unie van Zuid-Amerikaanse Naties\",\n" +
            "      \"South American Union\"\n" +
            "    ]\n" +
            "  }\n" +
            "],\n" +
            "\"cioc\": \"COL\"\n" +
            "}";

    public static String JSON_IP_INF="{\n" +
            "    \"city\": \"Mosquera\",\n" +
            "    \"continent_code\": \"SA\",\n" +
            "    \"continent_name\": \"South America\",\n" +
            "    \"country_code\": \"CO\",\n" +
            "    \"country_name\": \"Colombia\",\n" +
            "    \"ip\": \"186.80.52.15\",\n" +
            "    \"latitude\": 4.716670036315918,\n" +
            "    \"location\": {\n" +
            "        \"calling_code\": \"57\",\n" +
            "        \"capital\": \"Bogotá\",\n" +
            "        \"country_flag\": \"http://assets.ipapi.com/flags/co.svg\",\n" +
            "        \"country_flag_emoji\": \"\uD83C\uDDE8\uD83C\uDDF4\",\n" +
            "        \"country_flag_emoji_unicode\": \"U+1F1E8 U+1F1F4\",\n" +
            "        \"geoname_id\": 3674292,\n" +
            "        \"is_eu\": false,\n" +
            "        \"languages\": [\n" +
            "            {\n" +
            "                \"code\": \"es\",\n" +
            "                \"name\": \"Spanish\",\n" +
            "                \"nat\": \"Español\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"longitude\": -74.23332977294922,\n" +
            "    \"region_code\": \"CUN\",\n" +
            "    \"region_name\": \"Cundinamarca\",\n" +
            "    \"type\": \"ipv4\"\n" +
            "}";
    public static String JSON_CURRENCY = "{\n" +
            "    \"success\": true,\n" +
            "    \"timestamp\": 1619983444,\n" +
            "    \"base\": \"EUR\",\n" +
            "    \"date\": \"2021-05-02\",\n" +
            "    \"rates\": {\n" +
            "      \"AED\": 4.420449,\n" +
            "      \"AFN\": 93.757229,\n" +
            "      \"ALL\": 123.604549,\n" +
            "      \"AMD\": 629.69734,\n" +
            "      \"ANG\": 2.171115,\n" +
            "      \"AOA\": 787.487255,\n" +
            "      \"ARS\": 112.941481,\n" +
            "      \"AUD\": 1.559826,\n" +
            "      \"AWG\": 2.166901,\n" +
            "      \"AZN\": 2.049695,\n" +
            "      \"BAM\": 1.958279,\n" +
            "      \"BBD\": 2.442154,\n" +
            "      \"BDT\": 102.49966,\n" +
            "      \"BGN\": 1.956318,\n" +
            "      \"BHD\": 0.453767,\n" +
            "      \"BIF\": 2358.238616,\n" +
            "      \"BMD\": 1.2035,\n" +
            "      \"BND\": 1.606509,\n" +
            "      \"BOB\": 8.351642,\n" +
            "      \"BRL\": 6.545313,\n" +
            "      \"BSD\": 1.209512,\n" +
            "      \"BTC\": 0.000021236773,\n" +
            "      \"BTN\": 89.599731,\n" +
            "      \"BWP\": 13.139729,\n" +
            "      \"BYN\": 3.096572,\n" +
            "      \"BYR\": 23588.595929,\n" +
            "      \"BZD\": 2.438048,\n" +
            "      \"CAD\": 1.479011,\n" +
            "      \"CDF\": 2408.203279,\n" +
            "      \"CHF\": 1.098846,\n" +
            "      \"CLF\": 0.030998,\n" +
            "      \"CLP\": 855.32486,\n" +
            "      \"CNY\": 7.792057,\n" +
            "      \"COP\": 4493.418332,\n" +
            "      \"CRC\": 747.144189,\n" +
            "      \"CUC\": 1.2035,\n" +
            "      \"CUP\": 31.892744,\n" +
            "      \"CVE\": 110.403042,\n" +
            "      \"CZK\": 25.879815,\n" +
            "      \"DJF\": 215.319224,\n" +
            "      \"DKK\": 7.445174,\n" +
            "      \"DOP\": 68.711914,\n" +
            "      \"DZD\": 160.437385,\n" +
            "      \"EGP\": 18.822997,\n" +
            "      \"ERN\": 18.054797,\n" +
            "      \"ETB\": 50.728628,\n" +
            "      \"EUR\": 1,\n" +
            "      \"FJD\": 2.440758,\n" +
            "      \"FKP\": 0.874192,\n" +
            "      \"GBP\": 0.871155,\n" +
            "      \"GEL\": 4.164288,\n" +
            "      \"GGP\": 0.874192,\n" +
            "      \"GHS\": 6.978826,\n" +
            "      \"GIP\": 0.874192,\n" +
            "      \"GMD\": 61.559092,\n" +
            "      \"GNF\": 11980.780132,\n" +
            "      \"GTQ\": 9.334371,\n" +
            "      \"GYD\": 253.046396,\n" +
            "      \"HKD\": 9.347534,\n" +
            "      \"HNL\": 29.054328,\n" +
            "      \"HRK\": 7.556784,\n" +
            "      \"HTG\": 103.292151,\n" +
            "      \"HUF\": 360.270045,\n" +
            "      \"IDR\": 17381.78645,\n" +
            "      \"ILS\": 3.90301,\n" +
            "      \"IMP\": 0.874192,\n" +
            "      \"INR\": 89.17392,\n" +
            "      \"IQD\": 1764.666445,\n" +
            "      \"IRR\": 50673.358971,\n" +
            "      \"ISK\": 150.810973,\n" +
            "      \"JEP\": 0.874192,\n" +
            "      \"JMD\": 185.581041,\n" +
            "      \"JOD\": 0.853641,\n" +
            "      \"JPY\": 131.591836,\n" +
            "      \"KES\": 130.384926,\n" +
            "      \"KGS\": 102.053897,\n" +
            "      \"KHR\": 4896.121851,\n" +
            "      \"KMF\": 492.652687,\n" +
            "      \"KPW\": 1083.150045,\n" +
            "      \"KRW\": 1345.224327,\n" +
            "      \"KWD\": 0.362434,\n" +
            "      \"KYD\": 1.00796,\n" +
            "      \"KZT\": 520.210444,\n" +
            "      \"LAK\": 11376.624728,\n" +
            "      \"LBP\": 1828.786618,\n" +
            "      \"LKR\": 238.87768,\n" +
            "      \"LRD\": 207.06204,\n" +
            "      \"LSL\": 17.414545,\n" +
            "      \"LTL\": 3.553622,\n" +
            "      \"LVL\": 0.727984,\n" +
            "      \"LYD\": 5.408663,\n" +
            "      \"MAD\": 10.791593,\n" +
            "      \"MDL\": 21.420383,\n" +
            "      \"MGA\": 4605.238145,\n" +
            "      \"MKD\": 61.587005,\n" +
            "      \"MMK\": 1883.807813,\n" +
            "      \"MNT\": 3430.759552,\n" +
            "      \"MOP\": 9.673295,\n" +
            "      \"MRO\": 429.649219,\n" +
            "      \"MUR\": 48.500643,\n" +
            "      \"MVR\": 18.557362,\n" +
            "      \"MWK\": 953.636376,\n" +
            "      \"MXN\": 24.362802,\n" +
            "      \"MYR\": 4.928939,\n" +
            "      \"MZN\": 69.297787,\n" +
            "      \"NAD\": 17.234164,\n" +
            "      \"NGN\": 457.935661,\n" +
            "      \"NIO\": 42.241817,\n" +
            "      \"NOK\": 9.982308,\n" +
            "      \"NPR\": 143.359249,\n" +
            "      \"NZD\": 1.678149,\n" +
            "      \"OMR\": 0.463329,\n" +
            "      \"PAB\": 1.209512,\n" +
            "      \"PEN\": 4.579226,\n" +
            "      \"PGK\": 4.301278,\n" +
            "      \"PHP\": 58.056591,\n" +
            "      \"PKR\": 185.236009,\n" +
            "      \"PLN\": 4.558731,\n" +
            "      \"PYG\": 7893.269325,\n" +
            "      \"QAR\": 4.381959,\n" +
            "      \"RON\": 4.89572,\n" +
            "      \"RSD\": 117.747225,\n" +
            "      \"RUB\": 90.516299,\n" +
            "      \"RWF\": 1210.603675,\n" +
            "      \"SAR\": 4.513367,\n" +
            "      \"SBD\": 9.57823,\n" +
            "      \"SCR\": 17.822284,\n" +
            "      \"SDG\": 466.957829,\n" +
            "      \"SEK\": 10.171108,\n" +
            "      \"SGD\": 1.601515,\n" +
            "      \"SHP\": 0.874192,\n" +
            "      \"SLL\": 12317.820664,\n" +
            "      \"SOS\": 702.843705,\n" +
            "      \"SRD\": 17.03434,\n" +
            "      \"STD\": 24947.513314,\n" +
            "      \"SVC\": 10.583233,\n" +
            "      \"SYP\": 1513.482115,\n" +
            "      \"SZL\": 17.439305,\n" +
            "      \"THB\": 37.507674,\n" +
            "      \"TJS\": 13.794448,\n" +
            "      \"TMT\": 4.224284,\n" +
            "      \"TND\": 3.307244,\n" +
            "      \"TOP\": 2.720751,\n" +
            "      \"TRY\": 9.987315,\n" +
            "      \"TTD\": 8.215973,\n" +
            "      \"TWD\": 33.531306,\n" +
            "      \"TZS\": 2804.847032,\n" +
            "      \"UAH\": 33.575681,\n" +
            "      \"UGX\": 4326.409513,\n" +
            "      \"USD\": 1.2035,\n" +
            "      \"UYU\": 53.194512,\n" +
            "      \"UZS\": 12727.643971,\n" +
            "      \"VEF\": 257344628165.17136,\n" +
            "      \"VND\": 27884.865756,\n" +
            "      \"VUV\": 131.829999,\n" +
            "      \"WST\": 3.046933,\n" +
            "      \"XAF\": 656.778201,\n" +
            "      \"XAG\": 0.046489,\n" +
            "      \"XAU\": 0.00068,\n" +
            "      \"XCD\": 3.252519,\n" +
            "      \"XDR\": 0.841352,\n" +
            "      \"XOF\": 656.778201,\n" +
            "      \"XPF\": 119.687438,\n" +
            "      \"YER\": 301.386495,\n" +
            "      \"ZAR\": 17.448039,\n" +
            "      \"ZMK\": 10832.942809,\n" +
            "      \"ZMW\": 27.023389,\n" +
            "      \"ZWL\": 387.527168\n" +
            "    }\n" +
            "  }";

    public static OnlyAccessKeyRequest getRequest(){
        return new OnlyAccessKeyRequest("s0M3Key");
    }


    private ConstantsTest() {
        throw new UnsupportedOperationException();
    }


}
