package com.huseyinonur.pimservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
