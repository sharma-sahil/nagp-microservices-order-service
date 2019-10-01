package com.nagarro.microservices.orderservice.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
// @FeignClient(name = "product-service", url="localhost:8000")
@RibbonClient(name = "product-service")
// @FeignClient(name = "product-service")
@FeignClient(name = "netflix-api-zuul-gateway-server")
public interface ProductServiceProxy {

	@GetMapping("/product-service/products")
	// @GetMapping("/products")
	public List<ProductBean> getProducts();

}
