package com.example.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfiguracionMicroservicios {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
