package com.huseyinonur.pimservice.service;

import com.huseyinonur.pimservice.dto.PriceDto;
import com.huseyinonur.pimservice.mapper.PriceMapper;
import com.huseyinonur.pimservice.model.Price;
import com.huseyinonur.pimservice.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public PriceDto createPrice(PriceDto priceDto) {
        Price price = priceRepository.save(priceMapper.toEntity(priceDto));
        return priceMapper.toDto(price);
    }

}
