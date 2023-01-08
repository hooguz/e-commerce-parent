package com.huseyinonur.pimservice.mapper;


import com.huseyinonur.pimservice.dto.CategoryRequest;
import com.huseyinonur.pimservice.dto.CategoryResponse;
import com.huseyinonur.pimservice.model.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryRequest request);

    @Mappings({
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "updatedAt", source = "updatedAt")})
    CategoryResponse toResponseDto(Category entity);

    List<CategoryResponse> toResponseDtoList(List<Category> categories);
}