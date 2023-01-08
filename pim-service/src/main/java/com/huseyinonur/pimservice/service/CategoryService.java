package com.huseyinonur.pimservice.service;

import com.huseyinonur.pimservice.dto.CategoryRequest;
import com.huseyinonur.pimservice.dto.CategoryResponse;
import com.huseyinonur.pimservice.exception.ContentNotFoundException;
import com.huseyinonur.pimservice.exception.EntityNotFoundException;
import com.huseyinonur.pimservice.mapper.CategoryMapper;
import com.huseyinonur.pimservice.model.Category;
import com.huseyinonur.pimservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = categoryRepository.save(categoryMapper.toEntity(categoryRequest));
        return categoryMapper.toResponseDto(category);
    }

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll(Sort.sort(Category.class).by(Category::getId));
        if (categories.isEmpty()) {
            throw new EntityNotFoundException("No category found");
        }
        return categoryMapper.toResponseDtoList(categories);
    }

    public CategoryResponse getCategoryById(Long id) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        return categoryOpt.map(categoryMapper::toResponseDto).orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
    }

    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            category.setName(categoryRequest.getName());
            categoryRepository.save(category);
            return categoryMapper.toResponseDto(category);
        } else {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
    }

    public Long deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ContentNotFoundException("Category not found or already deleted with id: " + id);
        }
        categoryRepository.deleteById(id);
        return id;
    }

}

