package com.huseyinonur.pimservice.repository;

import com.huseyinonur.pimservice.model.Price;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAllByProductId(Long productId);

    List<Price> findAllByProductId(Long productId, Sort sort);

}