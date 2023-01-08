package com.huseyinonur.omservice.service;

import com.huseyinonur.omservice.dto.OrderDto;
import com.huseyinonur.omservice.exception.EntityNotFoundException;
import com.huseyinonur.omservice.mapper.OrderMapper;
import com.huseyinonur.omservice.mapper.OrderProductMapper;
import com.huseyinonur.omservice.model.Order;
import com.huseyinonur.omservice.model.OrderProduct;
import com.huseyinonur.omservice.repository.OrderProductRepository;
import com.huseyinonur.omservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final OrderMapper orderMapper;
    private final OrderProductMapper orderProductMapper;

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = orderMapper.toOrderDtoList(orders);
        orderDtos.forEach(orderDto -> {
            List<OrderProduct> orderProducts = orderProductRepository.findByOrderId(orderDto.getId());
            orderDto.setOrderProducts(orderProductMapper.toOrderProductDtoList(orderProducts));
        });
        if (orders.isEmpty()) {
            throw new EntityNotFoundException("No order found");
        }
        return orderDtos;
    }

    public List<OrderDto> getOrderById(Long id) {
        return null;
    }

    public OrderDto createOrder(OrderDto orderDto) {
        return null;
    }

    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        return null;
    }
}
