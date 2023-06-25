package com.example.java.metrics.infrastructure.aspect;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Timer {
    String metric();
    String action();
}
