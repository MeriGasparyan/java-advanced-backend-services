package org.example.homework1.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class CustomMetrics {

    private final MeterRegistry meterRegistry;

    @After("execution(* org.example.homework1.service.ProductService.save(..))")
    public void countProductCreated() {
        Counter.builder("products.created")
                .description("Total number of products created")
                .register(meterRegistry)
                .increment();
    }

    @After("execution(* org.example.homework1.service.ProductService.deleteById(..))")
    public void countProductDeleted() {
        Counter.builder("products.deleted")
                .description("Total number of products deleted")
                .register(meterRegistry)
                .increment();
    }

    @After("execution(* org.example.homework1.controller.AuthController.login(..))")
    public void countLoginAttempts() {
        Counter.builder("auth.login.attempts")
                .description("Total number of login attempts")
                .register(meterRegistry)
                .increment();
    }
}
