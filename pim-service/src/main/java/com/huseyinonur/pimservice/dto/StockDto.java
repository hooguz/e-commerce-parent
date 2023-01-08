package com.huseyinonur.pimservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {

    private Long id;
    private Long productId;
    private Integer quantity;
    private Date lastUpdate;
}
