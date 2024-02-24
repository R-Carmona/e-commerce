package com.rubencarmona.inditex.domain.service;

import com.rubencarmona.inditex.mock.RateMockRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.ZoneId;


@ExtendWith(SpringExtension.class)
class RateServiceUseCaseTest {

    @InjectMocks
    private RateServiceUseCase rateServiceUseCaseTest;

    private RateMockRepository rateMockRepository;

    @BeforeEach
    void setUp() {
        rateMockRepository = new RateMockRepository();
    }

    @Test
    @DisplayName("Should find product")
    void testFindByBrandProductBetweenDate() {
        // Setup
        var date = LocalDateTime.ofInstant(rateMockRepository.createDate(), ZoneId.systemDefault());

        // Run the test
        var result = rateServiceUseCaseTest.findByBrandProductBetweenDate(0L, 0L, date);

        // Verify the results
        Assertions.assertNull(result);
    }
}
