package com.kamalkavin96.stockMarketDataProvider;

import com.kamalkavin96.stockMarketDataProvider.controller.NSEEquityController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StockMarketDataProviderApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		// basic smoke test: context starts and controller bean is present
		assertThat(applicationContext).isNotNull();
		assertThat(applicationContext.getBean(NSEEquityController.class)).isNotNull();
	}

}
