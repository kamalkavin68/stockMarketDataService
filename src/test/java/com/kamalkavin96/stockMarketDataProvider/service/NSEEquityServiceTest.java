package com.kamalkavin96.stockMarketDataProvider.service;

import com.kamalkavin96.stockMarketDataProvider.model.NSEEquity;
import com.kamalkavin96.stockMarketDataProvider.repository.NSEEquityRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NSEEquityServiceTest {

    @Mock
    NSEEquityRepo nseEquityRepo;

    @InjectMocks
    NSEEquityService nseEquityService;

    @Test
    void getNseEquityList_returnsRepoList() {
        NSEEquity e = new NSEEquity(1L, "SYM", "Company", "EQ", LocalDate.of(2020,1,1), 10, 1, "ISIN123", 1, 100L);
        List<NSEEquity> expected = List.of(e);

        when(nseEquityRepo.findAll()).thenReturn(expected);

        List<NSEEquity> actual = nseEquityService.getNseEquityList();
        assertEquals(expected, actual);
    }
}
