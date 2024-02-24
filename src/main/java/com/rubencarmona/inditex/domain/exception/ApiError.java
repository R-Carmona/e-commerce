package com.rubencarmona.inditex.domain.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type Api error.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private Object status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime date;

    private String message;
}
