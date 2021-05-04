package com.meli.management.service.impl;

import com.meli.management.repository.api.BlackListIpRepository;
import com.meli.management.service.api.BlackListIpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BlackListIpServiceImpl implements BlackListIpService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlackListIpServiceImpl.class);

    private final BlackListIpRepository blackListIpRepository;

    public BlackListIpServiceImpl(BlackListIpRepository blackListIpRepository) {
        this.blackListIpRepository = blackListIpRepository;
    }

    @Override
    public Boolean isIpInBlackList(String ip) {
        LOGGER.info("Consulting : ".concat(ip));
        return blackListIpRepository.findAllByIpAddressAndEnabledIsTrueAndIsDeletedIsNull(ip).isPresent();
    }
}
