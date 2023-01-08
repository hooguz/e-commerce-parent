package com.huseyinonur.pimservice.mapper;

import com.huseyinonur.pimservice.dto.StockDto;
import com.huseyinonur.pimservice.model.Stock;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface StockMapper {

    @Mapping(target = "product.id", source = "productId")
    Stock toEntity(StockDto stockDto);

    @Mapping(target = "productId", source = "product.id")
    StockDto toDto(Stock stock);

}
