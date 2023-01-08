package com.huseyinonur.omservice.mapper;

import com.huseyinonur.omservice.dto.OrderDto;
import com.huseyinonur.omservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface OrderMapper {

    Order toEntity(OrderDto request);

    OrderDto toResponseDto(Order entity);

    List<OrderDto> toOrderDtoList(List<Order> orders);
}
