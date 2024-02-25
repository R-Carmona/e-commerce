package com.rubencarmona.inditex.application.adapter;

import com.rubencarmona.inditex.application.exception.ApiErrorExt;
import com.rubencarmona.inditex.application.mapper.RateServiceUseCaseMapper;
import com.rubencarmona.inditex.application.model.RateResponse;
import com.rubencarmona.inditex.domain.port.out.RateRepositoryPort;
import com.rubencarmona.inditex.domain.service.RateServiceUseCase;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Rate service use case ext.
 */
@RestController
@Api(tags = {"Api Prices"})
@RequestMapping("/api")
public class RateServiceUseCaseExt extends RateServiceUseCase {

    /**
     * The Rate service use case mapper.
     */
    private final RateServiceUseCaseMapper rateServiceUseCaseMapper;

    /**
     * Instantiates a new Rate service use case ext.
     *
     * @param rateRepositoryPort       the rate repository port
     * @param rateServiceUseCaseMapper the rate service use case mapper
     */
    public RateServiceUseCaseExt(RateRepositoryPort rateRepositoryPort, RateServiceUseCaseMapper rateServiceUseCaseMapper) {
        super(rateRepositoryPort);
        this.rateServiceUseCaseMapper = rateServiceUseCaseMapper;
    }

    /**
     * Gets rate.
     *
     * @param applicationDate the application date
     * @param productId       the product id
     * @param brandId         the brand id
     * @return the rate
     */
    @ApiOperation(
            value = "Return a price to apply on a given date.",
            nickname = "Return a price to apply on a given date.",
            response = RateResponse.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = RateResponse.class),
                    @ApiResponse(code = 400, message = "Bad Request", response = ApiErrorExt.class),
                    @ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorExt.class),
                    @ApiResponse(code = 404, message = "Price not found", response = ApiErrorExt.class),
            })
    @GetMapping("/price")
    public ResponseEntity<RateResponse> getRate(
            @ApiParam(name = "applicationDate",
                    value = "Date on which you want to apply the price",
                    required = true,
                    example = "2024-02-25T00:00:00.00Z")
            @RequestParam
            String applicationDate,
            @ApiParam(name = "productId",
                    value = "Product identifier",
                    required = true,
                    example = "35455")
            @RequestParam Long productId,
            @ApiParam(name = "brandId",
                    value = "Brand identifier",
                    required = true,
                    example = "1")
            @RequestParam Long brandId
    ) {

        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        var localDateTime = LocalDateTime.parse(applicationDate, formatter);

        var rate = this.findByBrandProductBetweenDate(brandId, productId, localDateTime);
        var rateMapper = rateServiceUseCaseMapper.toRateResponseDTO(rate);

        return ResponseEntity.ok().body(rateMapper);
    }
}
