package com.jeizas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author jeizas
 * @date 2018-12-23 23:38
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public Mono<String> test() {
        return Mono.just("杭州梦婪网络有限公司");
    }
}
