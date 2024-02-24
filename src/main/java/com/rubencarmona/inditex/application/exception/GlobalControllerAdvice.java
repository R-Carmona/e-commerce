package com.rubencarmona.inditex.application.exception;

import com.rubencarmona.inditex.domain.exception.RateNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * The type Global controller advice.
 */
@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    /**
     * The constant log.
     */
    private static final Logger log = Logger.getLogger(GlobalControllerAdvice.class.getName());

    /**
     * Operation response not found response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(RateNotFound.class)
    public ResponseEntity<ApiErrorExt> operationResponseNotFound(RateNotFound ex) {
        log.warning("Price Not Found: " + log.getName());

        ApiErrorExt apiError = new ApiErrorExt(
                HttpStatus.NOT_FOUND
                , LocalDateTime.now()
                , ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

}
