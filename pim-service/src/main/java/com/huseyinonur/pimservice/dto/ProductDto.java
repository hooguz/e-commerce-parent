package com.huseyinonur.pimservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private Long categoryId;

}
