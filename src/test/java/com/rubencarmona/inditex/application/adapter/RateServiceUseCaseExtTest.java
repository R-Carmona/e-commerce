package com.rubencarmona.inditex.application.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RateServiceUseCaseExtTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should NOT FOUND 404 OK")
    void testGetPriceCaseNotFound() throws Exception {
        // Run the test
        mockMvc.perform(get("/api/price")
                        .param("applicationDate", "2024-02-25T00:00:00.00Z")
                        .param("productId", "0")
                        .param("brandId", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Should get a Price 2020-06-14 10:00h with 200 OK")
    void testGetPriceCaseOne() throws Exception {
        mockMvc.perform(get("/api/price")
                        .param("applicationDate", "2020-06-14T10:00:00.00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00Z"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59Z"))
                .andExpect(jsonPath("$.price").value(35.5));
    }

    @Test
    @DisplayName("Should get a Price 2020-06-14 16:00h with 200 OK")
    void testGetPriceCaseTwo() throws Exception {
        mockMvc.perform(get("/api/price")
                        .param("applicationDate", "2020-06-14T16:00:00.00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00Z"))
                .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00Z"))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    @DisplayName("Should get a Price 2020-06-14 21:00h with 200 OK")
    void testGetPriceCaseThree() throws Exception {
        mockMvc.perform(get("/api/price")
                        .param("applicationDate", "2020-06-14T21:00:00.00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00Z"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59Z"))
                .andExpect(jsonPath("$.price").value(35.5));
    }

    @Test
    @DisplayName("Should get a Price 2020-06-15 10:00h with 200 OK")
    void testGetPriceCaseFour() throws Exception {
        mockMvc.perform(get("/api/price")
                        .param("applicationDate", "2020-06-15T10:00:00.00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00Z"))
                .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00Z"))
                .andExpect(jsonPath("$.price").value(30.5));
    }

    @Test
    @DisplayName("Should get a Price 2020-06-16 21:00h with 200 OK")
    void testGetPriceCaseFive() throws Exception {
        mockMvc.perform(get("/api/price")
                        .param("applicationDate", "2020-06-16T21:00:00.00Z")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00Z"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59Z"))
                .andExpect(jsonPath("$.price").value(38.95));
    }
}
