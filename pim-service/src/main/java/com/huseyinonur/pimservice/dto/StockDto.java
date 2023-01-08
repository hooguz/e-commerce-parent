package com.huseyinonur.pimservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StockDto extends BaseDto {

    private Long id;
    private Long productId;
    private Integer quantity;
    private LocalDateTime lastUpdate;
    @Builder
    public StockDto(LocalDateTime createdAt, LocalDateTime updatedAt, Long id, Long productId, Integer quantity, LocalDateTime lastUpdate) {
        super(createdAt, updatedAt);
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.lastUpdate = lastUpdate;
    }

}
