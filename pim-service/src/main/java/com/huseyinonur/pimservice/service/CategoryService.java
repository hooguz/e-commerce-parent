package com.huseyinonur.pimservice.service;

import com.huseyinonur.pimservice.dto.CategoryRequest;
import com.huseyinonur.pimservice.mapper.CategoryMapper;
import com.huseyinonur.pimservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public void createCategory(CategoryRequest categoryRequest) {
        categoryRepository.save(categoryMapper.toEntity(categoryRequest));
    }

}

