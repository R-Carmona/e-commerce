package com.rubencarmona.inditex.mock;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class RateMockRepository {
    public Instant createDate() {
        return LocalDateTime.of(2024, 1, 1, 0, 0, 0, 0).toInstant(ZoneOffset.UTC);
    }

}
