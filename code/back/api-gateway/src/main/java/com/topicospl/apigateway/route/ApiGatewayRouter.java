package com.topicospl.apigateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayRouter {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder rBuilder) {
		return rBuilder.routes()
					.route(p -> p.path("/producto/**").uri("lb://ms-inventario"))
				.build();
	}
	
}
