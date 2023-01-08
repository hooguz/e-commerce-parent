package com.huseyinonur.pimservice.controller;

import com.huseyinonur.pimservice.dto.StockDto;
import com.huseyinonur.pimservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDto>> getAllPrices() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<StockDto>> getAllPricesByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(stockService.findAllStocksByProduct(productId));
    }

}
