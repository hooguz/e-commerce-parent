package com.huseyinonur.pimservice.service;

import com.huseyinonur.pimservice.dto.StockDto;
import com.huseyinonur.pimservice.mapper.StockMapper;
import com.huseyinonur.pimservice.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public StockDto createStock(StockDto stockDto) {
        return stockMapper.toDto(stockRepository.save(stockMapper.toEntity(stockDto)));
    }

}
