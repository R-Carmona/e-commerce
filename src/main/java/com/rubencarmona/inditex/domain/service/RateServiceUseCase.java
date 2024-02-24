package com.rubencarmona.inditex.domain.service;

import com.rubencarmona.inditex.domain.model.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.rubencarmona.inditex.domain.model.port.in.RateServicePort;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RateServiceUseCase implements RateServicePort {
    @Override
    public Rate findByBrandProductBetweenDate(Long brandId, Long productId, LocalDateTime dateBetween) {
        return null;
    }
}
