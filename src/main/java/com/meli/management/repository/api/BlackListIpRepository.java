package com.meli.management.repository.api;

import com.meli.management.model.entity.BlackListIp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlackListIpRepository extends CrudRepository<BlackListIp,Long> {

    Optional<BlackListIp> findAllByIpAddressAndEnabledIsTrueAndIsDeletedIsNull(String ip);
}
