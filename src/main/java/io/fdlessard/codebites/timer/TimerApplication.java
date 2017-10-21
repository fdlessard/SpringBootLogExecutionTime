package io.fdlessard.codebites.timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class TimerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimerApplication.class, args);
	}




	public CustomerKeyGenerator customerKeyGenerator() {
		// configure and return an implementation of Spring's KeyGenerator SPI
		return new CustomerKeyGenerator();
	}

	@Bean
	public io.fdlessard.codebites.timer.CustomerJCacheManagerCustomizer cacheManagerCustomizer() {
		return new io.fdlessard.codebites.timer.CustomerJCacheManagerCustomizer();
	}
}




