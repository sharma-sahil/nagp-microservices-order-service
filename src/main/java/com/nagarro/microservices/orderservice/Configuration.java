package com.nagarro.microservices.orderservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("order-service")
public class Configuration {
	
	private int sla;

	public int getSla() {
		return sla;
	}

	public void setSla(int sla) {
		this.sla = sla;
	}
	
	

}
