package com.meli.management.util;

import com.meli.management.model.external.request.OnlyAccessKeyRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class TestObjects {

    @Test
    public void addVarToUrl() {
        String urlOrg="www.ickkck.com/{1}/{2}";
        List<String> stringList = Arrays.asList("parameter1","parameter2");
        String urlFinal="www.ickkck.com/parameter1/parameter2";
        Assertions.assertEquals(urlFinal,Util.addParametersToUrl(urlOrg,stringList));
    }

    @Test
    public void addParametersToUrl() throws UnsupportedEncodingException, URISyntaxException {
        String urlOrg="www.ickkck.com/some";
        OnlyAccessKeyRequest onlyAccessKeyRequest = ConstantsTest.getRequest();
        String urlFinal="www.ickkck.com/some?access_key=".concat(onlyAccessKeyRequest.getAccess_key());
        Assertions.assertEquals(urlFinal,Util.addParameterUrl(urlOrg,onlyAccessKeyRequest));
    }
}
