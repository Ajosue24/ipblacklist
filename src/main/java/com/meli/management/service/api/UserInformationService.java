package com.meli.management.service.api;

import com.meli.management.model.dto.UserInformationDTO;

public interface UserInformationService {

    UserInformationDTO getUserInformation(String ip);
}
