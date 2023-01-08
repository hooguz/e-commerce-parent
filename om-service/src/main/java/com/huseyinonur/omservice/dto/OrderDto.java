package com.huseyinonur.omservice.dto;

import com.huseyinonur.omservice.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private String customerName;
    private String customerAddress;
    private OrderStatus orderStatus;
    private BigDecimal totalPrice;
    private List<OrderProductDto> orderProducts;

}
