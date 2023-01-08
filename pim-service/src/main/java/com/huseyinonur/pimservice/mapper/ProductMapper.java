package com.huseyinonur.pimservice.mapper;

import com.huseyinonur.pimservice.dto.ProductDto;
import com.huseyinonur.pimservice.model.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    @Mapping(target = "category.id", source = "categoryId")
    Product toEntity(ProductDto productDto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

    @Mapping(target = "categoryId", source = "category.id")
    List<ProductDto> toProductDtoList(List<Product> products);
}
