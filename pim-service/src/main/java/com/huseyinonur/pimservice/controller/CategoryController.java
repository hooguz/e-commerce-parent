package com.huseyinonur.pimservice.controller;

import com.huseyinonur.pimservice.dto.CategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryResponse categoryResponse) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody CategoryResponse categoryResponse) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> delete(@PathVariable Long id) {
        return null;
    }

}
