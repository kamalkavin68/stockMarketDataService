package com.kamalkavin96.stockMarketDataProvider.controller;

import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import com.kamalkavin96.stockMarketDataProvider.service.NSEEquityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NSEEquityController.class)
class NSEEquityControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    NSEEquityService nseEquityService;

    @Test
    void getNSEEquityListMapping_returnsJsonList() throws Exception {
        NSEEquity e = new NSEEquity(1L, "SYM", "Company", "EQ", LocalDate.of(2020,1,1), 10, 1, "ISIN123", 1, 100L);
        when(nseEquityService.getNseEquityList()).thenReturn(List.of(e));

        mockMvc.perform(get("/api/v1/nse/equity-list"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].symbol").value("SYM"))
                .andExpect(jsonPath("$[0].nameOfCompany").value("Company"));
    }
}
