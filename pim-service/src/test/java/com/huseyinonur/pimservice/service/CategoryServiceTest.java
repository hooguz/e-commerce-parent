package com.huseyinonur.pimservice.service;

import com.huseyinonur.pimservice.dto.CategoryRequest;
import com.huseyinonur.pimservice.dto.CategoryResponse;
import com.huseyinonur.pimservice.mapper.CategoryMapper;
import com.huseyinonur.pimservice.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    private CategoryService categoryService;


    @BeforeEach
    void setUp() {
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryMapper = Mockito.mock(CategoryMapper.class);
        categoryService = new CategoryService(categoryRepository, categoryMapper);
    }

    @Test
    void createCategory() {
        CategoryRequest categoryRequest = CategoryRequest.builder()
                .name("test")
                .build();
        CategoryResponse expectedResponse = CategoryResponse.builder()
                .name("test")
                .id(1L)
                .build();

        Mockito.when(categoryService.createCategory(categoryRequest)).thenReturn(expectedResponse);
        CategoryResponse actualResponse = categoryService.createCategory(categoryRequest);
        assertNotNull(actualResponse);
        assertNotNull(actualResponse.getId());
        assertEquals(expectedResponse.getName(), actualResponse.getName());
        assertEquals(expectedResponse.getId(), actualResponse.getId());
    }

    @Test
    void getAllCategories() {
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void updateCategory() {
    }

    @Test
    void deleteCategory() {
    }
}