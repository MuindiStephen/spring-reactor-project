package com.stevemd.springreactorproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@RestController
public class TestController {

    @GetMapping("/hello")
    public Mono<String> hello(){
        return getHello()
                .zipWith(hey())
                .map(value-> value.getT1()+value.getT2()
                );
    }

    public Mono<String> getHello(){

        return Mono.just("Hello, this is reactive api")
                .delayElement(Duration.ofSeconds(5))
                .publishOn(Schedulers.boundedElastic());
    }public Mono<String> hey(){

        return Mono.just("   Hey, this is reactive api")
                .delayElement(Duration.ofSeconds(5))
                .publishOn(Schedulers.boundedElastic());
    }
}
