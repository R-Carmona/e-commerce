package com.rubencarmona.inditex.infrastructure.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type Rate mo.
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRICES")
public class RateMO {

    /**
     * The Id.
     */
    @Id
    @Column(name = "PRICE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Start date.
     */
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    /**
     * The End date.
     */
    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    /**
     * The Price list.
     */
    @Column(name = "PRICE_LIST", nullable = true)
    private Integer priceList;

    /**
     * The Brand id.
     */
    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;

    /**
     * The Product id.
     */
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    /**
     * The Priority.
     */
    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    /**
     * The Price.
     */
    @Column(name = "PRICE", nullable = false)
    private Double price;

    /**
     * The Curr.
     */
    @Column(name = "CURR", nullable = false)
    private String curr;
}

