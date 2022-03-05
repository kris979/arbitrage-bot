package com.agisoft.bot;

import com.agisoft.bot.exchanges.*;
import com.agisoft.bot.model.Deal;
import com.agisoft.bot.services.FundingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Configuration
public class BotApplication {

	@Bean
	public RestTemplate restTemplate() {
		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor(){
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
				request.getHeaders().set("bybtSecret", "01a7544d09b641b0bcd98acd693aa175");
				return execution.execute(request, body);
			}
		});
		return restTemplate;
	}

	@Bean
	public List<ExchangeClient> exchanges(FTX ftx, Binance binance, Okex okex) {
		List<ExchangeClient> exchanges = new ArrayList<>();
		exchanges.add(ftx);
		exchanges.add(binance);
		exchanges.add(okex);
		return exchanges;
	}


	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(BotApplication.class, args);
		final FundingService fundingService = context.getBean(FundingService.class);
		fundingService.collectFunding();
		final Deal symbolToTrade = fundingService.findSymbolToTrade();
		System.out.println(symbolToTrade);
	}

}


//		final BybtService bybtService = context.getBean(BybtService.class);
//		final BybtResponse response = bybtService.getFunding();
//		final List<Pair<Date, Double>> bybit = response.getFundingForExchange("Bybit");
//		bybit.forEach(System.out::println);

//		final ScrapingService bybtScrapingService = context.getBean(ScrapingService.class);
//		bybtScrapingService.scrape();