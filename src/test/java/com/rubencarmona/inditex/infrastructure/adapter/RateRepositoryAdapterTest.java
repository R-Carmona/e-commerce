package com.rubencarmona.inditex.infrastructure.adapter;

import com.rubencarmona.inditex.mock.RateMockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
class RateRepositoryAdapterTest {

    @InjectMocks
    private RateRepositoryAdapter rateRepositoryAdapterTest;

    private RateMockRepository rateMockRepository;

    @BeforeEach
    void setUp() {
        rateMockRepository = new RateMockRepository();
    }

    @Test
    @DisplayName("Should find product repository is Null")
    void testFindByBrandProductBetweenDate() {
        var date = rateMockRepository.createLocalDateTime();

        var result = rateRepositoryAdapterTest.findByBrandProductBetweenDate(0L, 0L, date);

        // Verify the results
        assertNull(result);
    }
}
