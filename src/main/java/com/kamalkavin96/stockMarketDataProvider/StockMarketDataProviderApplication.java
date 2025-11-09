package com.kamalkavin96.stockMarketDataProvider;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockMarketDataProviderApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().ignoreIfMalformed().load();
		try {
			dotenv.entries().forEach(entry->System.setProperty(entry.getKey(), entry.getValue()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		SpringApplication.run(StockMarketDataProviderApplication.class, args);
	}

}
