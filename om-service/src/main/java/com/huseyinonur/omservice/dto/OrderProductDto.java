package com.huseyinonur.omservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDto {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;

}
