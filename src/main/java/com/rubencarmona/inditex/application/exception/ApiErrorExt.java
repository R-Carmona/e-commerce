package com.rubencarmona.inditex.application.exception;

import com.rubencarmona.inditex.domain.exception.ApiError;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * The type Api error ext.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ApiErrorExt extends ApiError {
    /**
     * Instantiates a new Api error ext.
     *
     * @param status  the status
     * @param date    the date
     * @param message the message
     */
    public ApiErrorExt(Object status, LocalDateTime date, String message) {
        super(status, date, message);
    }
}
