package com.rubencarmona.inditex;

import com.rubencarmona.inditex.domain.service.RateServiceUseCase;
import com.rubencarmona.inditex.infrastructure.adapter.RateRepositoryAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InditexApplicationTests {

    @Autowired
    private InditexApplication inditexApplication;

    @Autowired
    private RateServiceUseCase rateServiceUseCase;

    @Autowired
    private RateRepositoryAdapter rateRepositoryAdapter;

    @Test
    void contextLoads() {
        assertThat(inditexApplication).isNotNull();
        assertThat(rateServiceUseCase).isNotNull();
        assertThat(rateRepositoryAdapter).isNotNull();
    }
}
