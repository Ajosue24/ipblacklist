package com.meli.management.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "col_blacklist_ip")
public class BlackListIp extends BaseEntity{

    private String ipAddress;

    public BlackListIp(Long id, Boolean enabled, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isDeleted, String ipAddress) {
        super(id, enabled, createdAt, updatedAt, isDeleted);
        this.ipAddress = ipAddress;
    }


}
