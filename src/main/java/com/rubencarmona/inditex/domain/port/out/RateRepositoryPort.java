package com.rubencarmona.inditex.domain.port.out;

import com.rubencarmona.inditex.domain.model.Rate;

import java.time.LocalDateTime;

/**
 * The interface Rate repository port.
 */
public interface RateRepositoryPort {
    /**
     * Find by brand product between date rate.
     *
     * @param brandId     the brand id
     * @param productId   the product id
     * @param dateBetween the date between
     * @return the rate
     */
    Rate findByBrandProductBetweenDate(Long brandId, Long productId, LocalDateTime dateBetween);
}
