package com.huseyinonur.pimservice.repository;

import com.huseyinonur.pimservice.model.Stock;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findAllByProductId(Long productId);

    List<Stock> findAllByProductId(Long productId, Sort sort);

}