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
					.route(p -> p.path("/inventario/producto").uri("lb://ms-inventario"))	
					.route(p -> p.path("/catalogo/**").uri("lb://ms-catalogo"))
					.route(p -> p.path("/autenticacion/**").uri("lb://ms-autenticacion"))
				.build();
	}
	
}
