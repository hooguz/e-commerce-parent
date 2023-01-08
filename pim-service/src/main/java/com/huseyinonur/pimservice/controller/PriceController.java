package com.huseyinonur.pimservice.controller;

import com.huseyinonur.pimservice.dto.PriceDto;
import com.huseyinonur.pimservice.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    private final PriceService priceService;

    @GetMapping
    public ResponseEntity<List<PriceDto>> getAllPrices() {
        return ResponseEntity.ok(priceService.getAllPrices());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<PriceDto>> getAllPricesByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(priceService.findAllPricesByProduct(productId));
    }

}
