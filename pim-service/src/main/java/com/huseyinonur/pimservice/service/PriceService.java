package com.huseyinonur.pimservice.service;

import com.huseyinonur.pimservice.dto.PriceDto;
import com.huseyinonur.pimservice.exception.EntityNotFoundException;
import com.huseyinonur.pimservice.mapper.PriceMapper;
import com.huseyinonur.pimservice.model.Price;
import com.huseyinonur.pimservice.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public PriceDto createPrice(PriceDto priceDto) {
        Price price = priceRepository.save(priceMapper.toEntity(priceDto));
        return priceMapper.toDto(price);
    }

    public List<PriceDto> getAllPrices() {
        List<Price> all = priceRepository.findAll(
                Sort.by(Sort.Direction.ASC, "product.id")
                        .and(Sort.by(Sort.Direction.DESC, "startDate")));
        if (all.isEmpty()) {
            throw new EntityNotFoundException("No prices found");
        }
        return priceMapper.toDtoList(all);
    }

    public List<PriceDto> findAllPricesByProduct(Long productId) {
        List<Price> all = priceRepository.findAllByProductId(productId,
                Sort.by(Sort.Direction.DESC, "startDate"));
        if (all.isEmpty()) {
            throw new EntityNotFoundException("No prices found");
        }
        return priceMapper.toDtoList(all);
    }

    public int deleteAllPricesByProductId(Long productId) throws EntityNotFoundException {
        List<Price> all = priceRepository.findAllByProductId(productId);
        if (all.isEmpty()) {
            throw new EntityNotFoundException("No prices found");
        }
        priceRepository.deleteAll(all);
        return all.size();
    }

}
