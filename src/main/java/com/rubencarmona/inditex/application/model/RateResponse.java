package com.rubencarmona.inditex.application.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * The type Rate response.
 */
@Data
@Builder
public class RateResponse {

    /**
     * The Product id.
     */
    @ApiModelProperty(value = "Product identifier", dataType = "Long", example = "54321", position = 1, required = true)
    private long productId;

    /**
     * The Brand id.
     */
    @ApiModelProperty(value = "Brand identifier", dataType = "Long", example = "5", position = 2, required = true)
    private long brandId;

    /**
     * The Price list.
     */
    @ApiModelProperty(value = "Price list", dataType = "Long", example = "5", position = 3, required = true)
    private long priceList;

    /**
     * The Start date.
     */
    @ApiModelProperty(value = "Start date", dataType = "Long", example = "2023-06-04T10:00:00.00Z", position = 4, required = true)
    private String startDate;

    /**
     * The End date.
     */
    @ApiModelProperty(value = "End date", dataType = "Long", example = "2023-06-04T10:00:00.00Z", position = 5, required = true)
    private String endDate;

    /**
     * The Price.
     */
    @ApiModelProperty(value = "Price", dataType = "Long", example = "55.5", position = 6, required = true)
    private float price;
}
