package com.meli.management.service;

import com.meli.management.model.entity.BlackListIp;
import com.meli.management.repository.api.BlackListIpRepository;
import com.meli.management.service.impl.BlackListIpServiceImpl;
import com.meli.management.util.ConstantsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BlackListIpServiceTest {

    @InjectMocks
    private BlackListIpServiceImpl blackListIpService;

    @Mock
    private BlackListIpRepository blackListIpRepository;

    @Test
    public void isIpInBlackList() {
        when(blackListIpRepository.findAllByIpAddressAndEnabledIsTrueAndIsDeletedIsNull(anyString())).thenReturn(Optional.of(new BlackListIp(1L, java.lang.Boolean.TRUE, LocalDateTime.now(), null, java.lang.Boolean.FALSE, anyString())));
        assertTrue(blackListIpService.isIpInBlackList(ConstantsTest.ANY_IP));
        verify(blackListIpRepository).findAllByIpAddressAndEnabledIsTrueAndIsDeletedIsNull(ConstantsTest.ANY_IP);
    }

}
