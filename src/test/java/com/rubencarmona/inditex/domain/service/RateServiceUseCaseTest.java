package com.rubencarmona.inditex.domain.service;

import com.rubencarmona.inditex.domain.model.exception.RateNotFound;
import com.rubencarmona.inditex.domain.port.out.RateRepositoryPort;
import com.rubencarmona.inditex.mock.RateMockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;


@ExtendWith(SpringExtension.class)
class RateServiceUseCaseTest {

    @Mock
    private RateRepositoryPort mockRateRepositoryPort;

    @InjectMocks
    private RateServiceUseCase rateServiceUseCaseTest;

    private RateMockRepository rateMockRepository;

    @BeforeEach
    void setUp() {
        rateMockRepository = new RateMockRepository();
    }

    @Test
    @DisplayName("Should find product")
    void testFindByBrandProductBetweenDateIsNull() {
        // Setup
        var date = LocalDateTime.ofInstant(rateMockRepository.createDate(), ZoneId.systemDefault());

        // Run the test
        assertThatThrownBy(() ->
                rateServiceUseCaseTest.findByBrandProductBetweenDate(0L, 0L, date))
                .isInstanceOf(RateNotFound.class);

    }

    @Test
    @DisplayName("Should find product")
    void testFindByBrandProductBetweenDate() {
        // Setup
        var date = LocalDateTime.ofInstant(rateMockRepository.createDate(), ZoneId.systemDefault());

        var expectedResult = rateMockRepository.createRate();
        var rate = rateMockRepository.createRate();

        given(mockRateRepositoryPort.findByBrandProductBetweenDate(anyLong(), anyLong(), any())).willReturn(rate);

        // Run the test
        var result = rateServiceUseCaseTest.findByBrandProductBetweenDate(0L, 0L, date);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
