package com.rubencarmona.inditex.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;

/**
 * The type Price.
 */
@Builder
@Data
public class Rate {

    private Long id;

    private Long brandId;

    private Instant startDate;

    private Instant endDate;

    private Long priceList;

    private Long productId;

    private Integer priority;

    private Double price;

    private String curr;
}
