package com.example.java.metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableAspectJAutoProxy
@ConfigurationPropertiesScan("com.example.java.metrics")
public class JavaMetricsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMetricsApplication.class, args);
    }

}
