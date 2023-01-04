package com.huseyinonur.pimservice.dto;


import com.huseyinonur.pimservice.model.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
@Data
public class CategoryRequest {

    private String name;
    private String description;
    private Category parentCategory;
    private List<Category> childrenCategories;

}
