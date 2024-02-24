package com.rubencarmona.inditex.mock;

import com.rubencarmona.inditex.domain.model.Rate;
import com.rubencarmona.inditex.infrastructure.model.RateMO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * The type Rate mock repository.
 */
public class RateMockRepository {

    /**
     * Create date instant.
     *
     * @return the instant
     */
    public Instant createDate() {
        return LocalDateTime.of(2024, 1, 1, 0, 0, 0, 0).toInstant(ZoneOffset.UTC);
    }

    /**
     * Create local date time local date time.
     *
     * @return the local date time
     */
    public LocalDateTime createLocalDateTime() {
        return LocalDateTime.ofInstant(createDate(), ZoneId.of("UTC"));
    }

    /**
     * Create rate rate.
     *
     * @return the rate
     */
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

    /**
     * Create rate mo rate mo.
     *
     * @return the rate mo
     */
    public RateMO createRateMO() {
        return RateMO.builder()
                .id(0L)
                .brandId(0L)
                .startDate(createLocalDateTime())
                .endDate(createLocalDateTime())
                .priceList(0)
                .productId(0L)
                .priority(0)
                .curr("EUR")
                .price(0.0)
                .build();
    }
}
