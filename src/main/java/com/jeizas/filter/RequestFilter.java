package com.jeizas.filter;

import com.jeizas.filter.decorator.PayloadServerWebExchangeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author jeizas
 * @date 2018-12-19 19:14
 */
@Component
@Order(2)
@Slf4j
public class RequestFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();
        return chain.filter(new PayloadServerWebExchangeDecorator(exchange))
                .doOnSuccess((done) -> success(startTime));
    }

    private void success(long startTime) {
        log.info("接口耗时：{}ms", (System.currentTimeMillis() - startTime) / 1000.0);
    }
}