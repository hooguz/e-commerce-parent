package com.huseyinonur.pimservice.util;

import com.huseyinonur.pimservice.dto.PriceDto;
import com.huseyinonur.pimservice.dto.StockDto;
import com.huseyinonur.pimservice.model.Product;
import com.huseyinonur.pimservice.service.PriceService;
import com.huseyinonur.pimservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import java.time.LocalDateTime;

@Component
public class ProductEntityListener {

    private static PriceService priceService;

    private static StockService stockService;

    @Autowired
    public void setPriceService(PriceService priceService) {
        ProductEntityListener.priceService = priceService;
    }

    @Autowired
    public void setStockService(StockService stockService) {
        ProductEntityListener.stockService = stockService;
    }

    @PostUpdate
    @PostPersist
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void onPostUpdateOrPersist(Product product) {
        try {
            PriceDto priceDto = PriceDto.builder()
                    .productId(product.getId())
                    .price(product.getPrice())
                    .startDate(LocalDateTime.now())
                    .build();
            priceService.createPrice(priceDto);
            StockDto stockDto = StockDto.builder()
                    .productId(product.getId())
                    .quantity(product.getStock())
                    .lastUpdate(LocalDateTime.now())
                    .build();
            stockService.createStock(stockDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
