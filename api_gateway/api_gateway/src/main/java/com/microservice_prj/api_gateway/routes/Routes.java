package com.microservice_prj.api_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> productServiceRouter() {
        return GatewayRouterFunctions.route("product_service").route(RequestPredicates.path("api/product"), HandlerFunctions
                .http("http://localhost:9001")).build();
    }
    @Bean
    public RouterFunction<ServerResponse> orderServiceRouter() {
        return GatewayRouterFunctions.route("order_service").route(RequestPredicates.path("api/order"), HandlerFunctions
                .http("http://localhost:9003")).build();
    }
    public RouterFunction<ServerResponse> inventoryServiceRouter() {
        return GatewayRouterFunctions.route("inventory_service").route(RequestPredicates.path("api/inventory"), HandlerFunctions
                .http("http://localhost:9004")).build();
    }
}
