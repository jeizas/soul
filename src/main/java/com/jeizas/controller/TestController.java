package com.jeizas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author jeizas
 * @date 2018-12-23 23:38
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Mono<String> test() {
        return Mono.just("hello world");
    }
}
