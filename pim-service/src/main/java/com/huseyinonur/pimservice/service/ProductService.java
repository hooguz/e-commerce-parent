package com.huseyinonur.pimservice.service;

import com.huseyinonur.pimservice.dto.ProductDto;
import com.huseyinonur.pimservice.exception.ContentNotFoundException;
import com.huseyinonur.pimservice.exception.EntityNotFoundException;
import com.huseyinonur.pimservice.mapper.ProductMapper;
import com.huseyinonur.pimservice.model.Product;
import com.huseyinonur.pimservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll(Sort.sort(Product.class).by(Product::getId));
        return productMapper.toProductDtoList(products);
    }

    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return productMapper.toDto(product);
    }


    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productMapper.toEntity(productDto);
            product.setId(id);
            productRepository.save(product);
            return productMapper.toDto(product);
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

    public Long deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ContentNotFoundException("Product not found or already deleted with id: " + id);
        }
        productRepository.deleteById(id);
        return id;
    }
}
