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

    /**
     * The Id.
     */
    private Long id;

    /**
     * The Brand id.
     */
    private Long brandId;

    /**
     * The Start date.
     */
    private Instant startDate;

    /**
     * The End date.
     */
    private Instant endDate;

    /**
     * The Price list.
     */
    private Long priceList;

    /**
     * The Product id.
     */
    private Long productId;

    /**
     * The Priority.
     */
    private Integer priority;

    /**
     * The Price.
     */
    private Double price;

    /**
     * The Curr.
     */
    private String curr;
}
