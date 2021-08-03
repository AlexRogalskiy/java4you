package com.sensiblemetrics.api.alpenidos.pattern.spring_boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by indrek.ruubel on 03/07/2016.
 * <p>
 * Proxy pattern:
 * The intent of this pattern is to provide a "Placeholder" for an object to control references to it.
 * https://www.oodesign.com/proxy-pattern.html
 * <p>
 * Also we're using aspect-oriented programming here.
 * https://en.wikipedia.org/wiki/Aspect-oriented_programming
 */
@Aspect
@Component
public class AroundGetContactsAspect {

    @Pointcut("execution(* com.sensiblemetrics.api.alpenidos.pattern.spring_boot.service.BankService.*(..))")
    public void serviceMethod() {
    }

    /**
     * In this case we wrap around the real method, controlling the input/output of that method, being a proxy.
     * As a simple example we measure method execution time.
     */
    @Around("serviceMethod()")
    public Object profile(final ProceedingJoinPoint pjp) {
        final LocalDateTime start = LocalDateTime.now();
        Object task = null;
        try {
            task = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        final LocalDateTime end = LocalDateTime.now();
        final Duration duration = Duration.between(start, end);
        System.out.println("Execution took: " + duration.toMillis() + " ms");
        return task;
    }
}
