package com.huseyinonur.pimservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto extends BaseDto {

    private Long id;
    private Long productId;
    private BigDecimal price;
    private LocalDateTime startDate;
}
