package com.rubencarmona.inditex.infrastructure.exception;

import com.rubencarmona.inditex.domain.exception.RateNotFound;

public class RateNotFoundExt extends RateNotFound {
    public RateNotFoundExt(String msg) {
        super(msg);
    }
}
