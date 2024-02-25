package com.rubencarmona.inditex.domain.service;

import com.rubencarmona.inditex.domain.exception.RateNotFound;
import com.rubencarmona.inditex.domain.model.Rate;
import com.rubencarmona.inditex.domain.port.in.RateServicePort;
import com.rubencarmona.inditex.domain.port.out.RateRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * The type Rate service use case.
 */
@Service
@RequiredArgsConstructor
public class RateServiceUseCase implements RateServicePort {

    /**
     * The Rate repository port.
     */
    private final RateRepositoryPort rateRepositoryPort;

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
        var rate = rateRepositoryPort.findByBrandProductBetweenDate(brandId, productId, applicationDate);

        if (rate == null) {
            throw new RateNotFound("Price not found");
        }
        return rate;
    }
}
