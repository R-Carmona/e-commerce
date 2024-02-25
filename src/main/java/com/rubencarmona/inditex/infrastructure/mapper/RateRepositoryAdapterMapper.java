package com.rubencarmona.inditex.infrastructure.mapper;

import com.rubencarmona.inditex.domain.model.Rate;
import com.rubencarmona.inditex.infrastructure.model.RateMO;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The interface Rate repository adapter mapper.
 */
@Mapper(componentModel = "spring")
public interface RateRepositoryAdapterMapper {

    /**
     * To domain rate.
     *
     * @param rateMO the price mo
     * @return the rate
     */
    Rate toDomain(RateMO rateMO);

    /**
     * Map string.
     *
     * @param dateTime the date time
     * @return the string
     */
    default String map(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS'Z'"));
    }
}
