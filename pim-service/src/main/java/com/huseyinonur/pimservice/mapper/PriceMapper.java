package com.huseyinonur.pimservice.mapper;

import com.huseyinonur.pimservice.dto.PriceDto;
import com.huseyinonur.pimservice.model.Price;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface PriceMapper {

    @Mapping(target = "product.id", source = "productId")
    Price toEntity(PriceDto priceDto);

    @Mapping(target = "productId", source = "product.id")
    PriceDto toDto(Price price);

    @Mapping(target = "productId", source = "product.id")
    List<PriceDto> toDtoList(List<Price> all);
}
