package com.example.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfiguracionWeb {

	//<bean id="restTemplate" class="org.springframework.web.client.RestTemplate"/>
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}	
}
