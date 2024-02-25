package com.rubencarmona.inditex.infrastructure.adapter;

import com.rubencarmona.inditex.domain.model.Rate;
import com.rubencarmona.inditex.domain.port.out.RateRepositoryPort;
import com.rubencarmona.inditex.infrastructure.exception.RateNotFoundExt;
import com.rubencarmona.inditex.infrastructure.mapper.RateRepositoryAdapterMapper;
import com.rubencarmona.inditex.infrastructure.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * The type Rate repository adapter.
 */
@Service
@RequiredArgsConstructor
public class RateRepositoryAdapter implements RateRepositoryPort {

    /**
     * The Rate repository.
     */
    private final RateRepository rateRepository;
    /**
     * The Rate repository adapter mapper.
     */
    private final RateRepositoryAdapterMapper rateRepositoryAdapterMapper;

    /**
     * Find by brand product between date rate.
     *
     * @param brandId         the brand id
     * @param productId       the product id
     * @param applicationDate the application date
     * @return the rate
     */
    @Override
    public Rate findByBrandProductBetweenDate(Long brandId, Long productId, LocalDateTime applicationDate) {
        var priceMOS = rateRepository.findAllByBrandIdAndProductIdBetweenDates(brandId, productId, applicationDate);

        if (!priceMOS.isEmpty()) {
            return rateRepositoryAdapterMapper.toDomain(priceMOS.get(0));
        } else {
            throw new RateNotFoundExt("Price Not Found");
        }
    }
}
