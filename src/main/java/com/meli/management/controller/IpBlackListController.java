package com.meli.management.controller;

import com.google.common.net.InetAddresses;
import com.meli.management.commons.StandardJsonResponse;
import com.meli.management.exception.BusinessException;
import com.meli.management.service.api.BlackListIpService;
import com.meli.management.util.Constants;
import com.meli.management.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/blacklist")
public class IpBlackListController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IpBlackListController.class);

    @Autowired
    private BlackListIpService blackListIpService;


    @GetMapping()
    public ResponseEntity<StandardJsonResponse> validateIpAddress(HttpServletRequest httpServletRequest, @RequestParam(value = "ip", required = false) String ip) {
        StandardJsonResponse standardJsonResponse;
        try {
            if (ip == null) {
                ip = Util.getClientIP(httpServletRequest);
            }
            if (!InetAddresses.isInetAddress(ip)) {
                throw new BusinessException("Invalid Ip");
            }
            standardJsonResponse = new StandardJsonResponse().onlySuccessMessageAndData(Constants.SUCCESS, blackListIpService.isIpInBlackList(ip));
            return new ResponseEntity<>(standardJsonResponse, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("error in blacklist", e);
            standardJsonResponse = new StandardJsonResponse<Boolean>().onlyErrorBadRequest(e.getMessage(), null);
            return new ResponseEntity<>(standardJsonResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
