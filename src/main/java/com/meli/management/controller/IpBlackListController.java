package com.meli.management.controller;

import com.meli.management.service.api.BlackListIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blacklist")
public class IpBlackListController {

    @Autowired
    private BlackListIpService blackListIpService;


    @GetMapping()
    public ResponseEntity<?> validateIpAddress(@RequestParam("ip") String ip) {

        blackListIpService.isIpInBlackList(ip);
        return new ResponseEntity<>("asdf", HttpStatus.OK);
    }
}
