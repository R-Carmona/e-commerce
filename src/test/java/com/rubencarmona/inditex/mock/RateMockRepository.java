package com.rubencarmona.inditex.mock;

import com.rubencarmona.inditex.domain.model.Rate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class RateMockRepository {
    public Instant createDate() {
        return LocalDateTime.of(2024, 1, 1, 0, 0, 0, 0).toInstant(ZoneOffset.UTC);
    }

    public Rate createRate() {
        return Rate.builder()
                .brandId(0L)
                .priority(0)
                .startDate(createDate())
                .endDate(createDate())
                .priceList(0L)
                .productId(0L)
                .price(0.0)
                .build();
    }
}
