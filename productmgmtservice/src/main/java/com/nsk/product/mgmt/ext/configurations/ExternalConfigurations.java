package com.nsk.product.mgmt.ext.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExternalConfigurations {

	@Bean
	public RestTemplate restTemplates() {
		return new RestTemplate();
	}

}
