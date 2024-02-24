package com.rubencarmona.inditex.port.in;

import com.rubencarmona.inditex.domain.Rate;
import java.time.LocalDateTime;

/**
 * The interface Rate service port.
 */
public interface RateServicePort {
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
