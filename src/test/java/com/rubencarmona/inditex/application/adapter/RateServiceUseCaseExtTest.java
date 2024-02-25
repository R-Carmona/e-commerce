package com.rubencarmona.inditex.application.adapter;

import com.rubencarmona.inditex.application.mapper.RateServiceUseCaseMapper;
import com.rubencarmona.inditex.domain.port.out.RateRepositoryPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class RateServiceUseCaseExtTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RateRepositoryPort mockRateRepositoryPort;

    @MockBean
    private RateServiceUseCaseMapper mockRateServiceUseCaseMapper;

    @Test
    @DisplayName("Should get a Price 2020-06-14 10:00h with 200 OK")
    void testGetPriceCaseOne() throws Exception {

        // Run the test
        var response = mockMvc.perform(get("/api/price")
                        .param("applicationDate", "2024-02-25T00:00:00.00Z")
                        .param("productId", "0")
                        .param("brandId", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
    }

}
