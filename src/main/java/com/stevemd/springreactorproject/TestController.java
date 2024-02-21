package com.stevemd.springreactorproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @GetMapping("/hello")
    public Mono<String> hello(){
        return getHello();
    }

    public Mono<String> getHello(){
        return Mono.just("Hello, this is reactive api");
    }
}
