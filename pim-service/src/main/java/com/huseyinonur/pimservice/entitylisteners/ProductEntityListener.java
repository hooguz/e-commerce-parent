package com.huseyinonur.pimservice.entitylisteners;

import com.huseyinonur.pimservice.dto.PriceDto;
import com.huseyinonur.pimservice.dto.StockDto;
import com.huseyinonur.pimservice.exception.EntityNotFoundException;
import com.huseyinonur.pimservice.model.Product;
import com.huseyinonur.pimservice.service.PriceService;
import com.huseyinonur.pimservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;
import java.time.LocalDateTime;

@Component
public class ProductEntityListener {

    private static PriceService priceService;

    private static StockService stockService;

    @Autowired
    public void init(PriceService priceService, StockService stockService) {
        ProductEntityListener.priceService = priceService;
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


    @PreRemove
    private void onDestroy(Product product) {
        try {
            priceService.deleteAllPricesByProductId(product.getId());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        try {
            stockService.deleteAllStocksByProductId(product.getId());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
    }

}
