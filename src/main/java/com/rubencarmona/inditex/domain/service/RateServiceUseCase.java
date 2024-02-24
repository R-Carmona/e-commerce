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

    private final RateRepositoryPort rateRepositoryPort;

    @Override
    public Rate findByBrandProductBetweenDate(Long brandId, Long productId, LocalDateTime applicationDate) {
        var rate = rateRepositoryPort.findByBrandProductBetweenDate(brandId, productId, applicationDate);

        if (rate == null) {
            throw new RateNotFound("Price not found");
        }
        return rate;
    }
}
