package com.rubencarmona.inditex.application.mapper;

import com.rubencarmona.inditex.application.model.RateResponse;
import com.rubencarmona.inditex.domain.model.Rate;
import org.mapstruct.Mapper;

/**
 * The interface Rate service use case mapper.
 */
@Mapper(componentModel = "spring")
public interface RateServiceUseCaseMapper {

    /**
     * To rate response dto rate response.
     *
     * @param rate the rate
     * @return the rate response
     */
    RateResponse toRateResponseDTO(Rate rate);
}
