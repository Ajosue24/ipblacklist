package com.meli.management.controller;

import com.meli.management.service.api.IpInformationService;
import com.meli.management.service.api.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information")
public class IpInformationController {

    @Autowired
    private UserInformationService userInformationService;

    //@Autowired
    //private IStatsService statsService;

   /* @Operation(value = "Get DNA evaluated stats", produces = MediaType.APPLICATION_JSON_VALUE, response = StatsResponseDTO.class)
    @ApiResponse(code = 200, message = "OK")*/
    @GetMapping()
    public ResponseEntity<?> validateIpAddress(@RequestParam("ip") String ip) {
        userInformationService.getUserInformation(ip);
        return new ResponseEntity<>("asdf", HttpStatus.OK);
    }

}
