package com.huseyinonur.pimservice.util;

import com.huseyinonur.pimservice.model.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class BaseEntityListener {
    @PrePersist
    public void onPrePersist(BaseEntity entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate(BaseEntity entity) {
        entity.setUpdatedAt(LocalDateTime.now());
    }
}
