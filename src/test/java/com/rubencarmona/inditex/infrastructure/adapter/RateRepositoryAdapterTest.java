package com.rubencarmona.inditex.infrastructure.adapter;

import com.rubencarmona.inditex.domain.exception.RateNotFound;
import com.rubencarmona.inditex.infrastructure.mapper.RateRepositoryAdapterMapper;
import com.rubencarmona.inditex.infrastructure.repository.RateRepository;
import com.rubencarmona.inditex.mock.RateMockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class RateRepositoryAdapterTest {

    @Mock
    private RateRepository mockRateRepository;

    @Mock
    private RateRepositoryAdapterMapper mockRateRepositoryAdapterMapper;


    @InjectMocks
    private RateRepositoryAdapter rateRepositoryAdapterTest;

    private RateMockRepository rateMockRepository;

    @BeforeEach
    void setUp() {
        rateMockRepository = new RateMockRepository();
    }

    @Test
    @DisplayName("Should find product repository is empty list")
    void testFindByBrandProductBetweenDateEmptyList() {
        var date = rateMockRepository.createLocalDateTime();

        given(mockRateRepository.findAllByBrandIdAndProductIdBetweenDates(anyLong(), anyLong(), any())).willReturn(List.of());

        // Run the test
        assertThatThrownBy(() ->
                rateRepositoryAdapterTest.findByBrandProductBetweenDate(0L, 0L, date))
                .isInstanceOf(RateNotFound.class);
    }

    @Test
    @DisplayName("Should get find product price")
    void testFindByBrandProductBetweenDate() {
        // Setup
        var expectedResult = rateMockRepository.createRate();
        var date = rateMockRepository.createLocalDateTime();
        var rate = rateMockRepository.createRate();
        var rateMO = rateMockRepository.createRateMO();

        given(mockRateRepository.findAllByBrandIdAndProductIdBetweenDates(anyLong(), anyLong(), any())).willReturn(List.of(rateMO));
        given(mockRateRepositoryAdapterMapper.toDomain(any())).willReturn(rate);

        // Run the test
        var result = rateRepositoryAdapterTest.findByBrandProductBetweenDate(0L, 0L, date);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
