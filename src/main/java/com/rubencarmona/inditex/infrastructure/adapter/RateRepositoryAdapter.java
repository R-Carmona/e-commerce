package com.rubencarmona.inditex.infrastructure.adapter;

import com.rubencarmona.inditex.domain.model.Rate;
import com.rubencarmona.inditex.domain.port.out.RateRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RateRepositoryAdapter implements RateRepositoryPort {
    @Override
    public Rate findByBrandProductBetweenDate(Long brandId, Long productId, LocalDateTime dateBetween) {
        return null;
    }
}
