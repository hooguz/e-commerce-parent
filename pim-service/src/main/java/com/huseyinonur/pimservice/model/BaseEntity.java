package com.huseyinonur.pimservice.model;

import com.huseyinonur.pimservice.entitylisteners.BaseEntityListener;
import lombok.Data;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public class BaseEntity {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
