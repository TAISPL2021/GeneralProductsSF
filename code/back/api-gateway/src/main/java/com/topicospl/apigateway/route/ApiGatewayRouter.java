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
					.route(p -> p.path("/inventario/producto").uri("http://msinventario-env.eba-zs269i4q.us-east-1.elasticbeanstalk.com/"))	
					.route(p -> p.path("/catalogo/**").uri("http://mscatalogo-env.eba-zmxuircd.us-east-1.elasticbeanstalk.com/"))
					.route(p -> p.path("/carrito/**").uri("http://mscatalogo-env.eba-zmxuircd.us-east-1.elasticbeanstalk.com/"))
					.route(p -> p.path("/autenticacion/**").uri("http://msautenticacion-env.eba-fk9p9ffv.us-east-1.elasticbeanstalk.com/"))
					.route(p -> p.path("/administracion/**").uri("http://msadministracion-env.eba-9pz4umru.us-east-1.elasticbeanstalk.com/"))
				.build();
	}
	
}
