package com.huseyinonur.pimservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PriceDto extends BaseDto {

    private Long id;
    private Long productId;
    private BigDecimal price;
    private LocalDateTime startDate;
    @Builder
    public PriceDto(LocalDateTime createdAt, LocalDateTime updatedAt, Long id, Long productId, BigDecimal price, LocalDateTime startDate) {
        super(createdAt, updatedAt);
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.startDate = startDate;
    }

}
