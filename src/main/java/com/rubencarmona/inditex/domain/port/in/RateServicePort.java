package com.rubencarmona.inditex.domain.port.in;

import com.rubencarmona.inditex.domain.model.Rate;

import java.time.LocalDateTime;

/**
 * The interface Rate service port.
 */
public interface RateServicePort {
    /**
     * Find by brand product between date rate.
     *
     * @param brandId         the brand id
     * @param productId       the product id
     * @param applicationDate the date between
     * @return the rate
     */
    Rate findByBrandProductBetweenDate(Long brandId, Long productId, LocalDateTime applicationDate);
}
