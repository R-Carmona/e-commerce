package com.rubencarmona.inditex.domain.service;

import com.rubencarmona.inditex.domain.model.Rate;
import com.rubencarmona.inditex.domain.model.exception.RateNotFound;
import com.rubencarmona.inditex.domain.model.port.in.RateServicePort;
import com.rubencarmona.inditex.domain.port.out.RateRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RateServiceUseCase implements RateServicePort {

    private final RateRepositoryPort rateRepositoryPort;

    @Override
    public Rate findByBrandProductBetweenDate(Long brandId, Long productId, LocalDateTime dateBetween) {
        var rate = rateRepositoryPort.findByBrandProductBetweenDate(brandId, productId, dateBetween);

        if (rate == null) {
            throw new RateNotFound("Price not found");
        }
        return rate;
    }
}
