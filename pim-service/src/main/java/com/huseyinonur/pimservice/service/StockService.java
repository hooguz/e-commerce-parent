package com.huseyinonur.pimservice.service;

import com.huseyinonur.pimservice.dto.StockDto;
import com.huseyinonur.pimservice.exception.EntityNotFoundException;
import com.huseyinonur.pimservice.mapper.StockMapper;
import com.huseyinonur.pimservice.model.Stock;
import com.huseyinonur.pimservice.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public StockDto createStock(StockDto stockDto) {
        return stockMapper.toDto(stockRepository.save(stockMapper.toEntity(stockDto)));
    }

    public List<StockDto> getAllStocks() {
        List<Stock> all = stockRepository.findAll(
                Sort.by(Sort.Direction.ASC, "product.id")
                        .and(Sort.by(Sort.Direction.DESC, "lastUpdate")));
        if (all.isEmpty()) {
            throw new EntityNotFoundException("No Stocks found");
        }
        return stockMapper.toDtoList(all);
    }

    public List<StockDto> findAllStocksByProduct(Long productId) {
        List<Stock> all = stockRepository.findAllByProductId(productId,
                Sort.by(Sort.Direction.DESC, "lastUpdate"));
        if (all.isEmpty()) {
            throw new EntityNotFoundException("No Stocks found");
        }
        return stockMapper.toDtoList(all);
    }

    public int deleteAllStocksByProductId(Long productId) throws EntityNotFoundException {
        List<Stock> all = stockRepository.findAllByProductId(productId);
        if (all.isEmpty()) {
            throw new EntityNotFoundException("No Stocks found");
        }
        stockRepository.deleteAll(all);
        return all.size();
    }

}
