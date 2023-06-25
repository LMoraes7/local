package com.example.java.metrics.infrastructure.metrics.publisher;

import com.example.java.metrics.application.metrics.MetricsPublisher;
import com.example.java.metrics.application.metrics.event.login.FailedLoginEvent;
import com.example.java.metrics.application.metrics.event.login.LoginSuccessfullyEvent;
import com.example.java.metrics.application.metrics.event.timer.ActionRunTimerEvent;
import com.example.java.metrics.application.metrics.event.user.FailedToCreateUserEvent;
import com.example.java.metrics.application.metrics.event.user.UserCreatedSuccessfullyEvent;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;

@Component
public final class PrometheusMetricsPublisher implements MetricsPublisher {

    private final MeterRegistry meterRegistry;

    public PrometheusMetricsPublisher(final MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void loginSuccessfullyEvent(final LoginSuccessfullyEvent event) {
        this.meterRegistry.counter(
                "successful.authentication",
                List.of(Tag.of("username", event.getUsername()))
        ).increment();
    }

    @Override
    public void failedLoginEvent(final FailedLoginEvent event) {
        this.meterRegistry.counter(
                "failed.authentication",
                List.of(Tag.of("username", event.getUsername()))
        ).increment();
    }

    @Override
    public void userCreatedSuccessfullyEvent(final UserCreatedSuccessfullyEvent event) {
        this.meterRegistry.counter(
                "new.user.created",
                List.of(Tag.of("username", event.getUsername()))
        ).increment();
    }

    @Override
    public void failedToCreateUserEvent(final FailedToCreateUserEvent event) {
        this.meterRegistry.counter(
                "failed.create.user",
                List.of(
                        Tag.of("username", event.getUsername()),
                        Tag.of("code", event.getCode())
                )
        ).increment();
    }

    @Override
    public void actionRunTimerEvent(final ActionRunTimerEvent event) {
        Timer.builder(event.getMetricName())
                .tags(
                        List.of(
                                Tag.of("action", event.getAction()),
                                Tag.of("successfully.executed", event.isActionPerformedSuccessfully().toString())
                        )
                ).sla(
                        Duration.of(50, MILLIS),
                        Duration.of(100, MILLIS),
                        Duration.of(200, MILLIS),
                        Duration.of(300, MILLIS),
                        Duration.of(500, MILLIS),
                        Duration.of(1, SECONDS)
                ).register(meterRegistry)
                .record(event.getMeasurement(), event.getTimeUnit());
    }

}
