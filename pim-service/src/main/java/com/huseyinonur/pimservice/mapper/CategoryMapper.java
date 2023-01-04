package com.huseyinonur.pimservice.mapper;


import com.huseyinonur.pimservice.dto.CategoryRequest;
import com.huseyinonur.pimservice.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface CategoryMapper {

    Category toEntity(CategoryRequest categoryRequest);

    CategoryRequest toDto(Category category);
}
