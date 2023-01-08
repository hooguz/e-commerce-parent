package com.huseyinonur.omservice.mapper;

import com.huseyinonur.omservice.dto.OrderProductDto;
import com.huseyinonur.omservice.model.OrderProduct;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface OrderProductMapper {

    OrderProduct toEntity(OrderProductDto request);

    OrderProductDto toResponseDto(OrderProduct entity);

    List<OrderProductDto> toOrderProductDtoList(List<OrderProduct> orderProducts);
}
