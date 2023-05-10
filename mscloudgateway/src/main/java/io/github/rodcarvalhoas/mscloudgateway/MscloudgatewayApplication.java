package io.github.rodcarvalhoas.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscloudgatewayApplication.class, args);
	}

	//Personalização de rotas para os nossos Ms
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder
				.routes()
					.route(r -> r.path("/usuario/**").uri("lb://msusuario"))
					.route(r -> r.path("/campo/**").uri("lb://mspartida"))
					.route(r -> r.path("/partida/**").uri("lb://mspartida"))
					.route(r -> r.path("/jogador/**").uri("lb://msjogador"))

				.build();
	}

}


