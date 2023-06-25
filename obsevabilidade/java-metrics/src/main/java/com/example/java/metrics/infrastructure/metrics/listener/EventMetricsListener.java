package com.example.java.metrics.infrastructure.metrics.listener;

import com.example.java.metrics.application.metrics.MetricsPublisher;
import com.example.java.metrics.application.metrics.event.login.FailedLoginEvent;
import com.example.java.metrics.application.metrics.event.timer.ActionRunTimerEvent;
import com.example.java.metrics.application.metrics.event.user.FailedToCreateUserEvent;
import com.example.java.metrics.application.metrics.event.login.LoginSuccessfullyEvent;
import com.example.java.metrics.application.metrics.event.user.UserCreatedSuccessfullyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventMetricsListener {

    private final MetricsPublisher metricsPublisher;

    public EventMetricsListener(final MetricsPublisher metricsPublisher) {
        this.metricsPublisher = metricsPublisher;
    }

    @Async
    @EventListener
    public void loginSuccessfullyEvent(final LoginSuccessfullyEvent event) {
        this.metricsPublisher.loginSuccessfullyEvent(event);
    }

    @Async
    @EventListener
    public void failedLoginEvent(final FailedLoginEvent event) {
        this.metricsPublisher.failedLoginEvent(event);
    }

    @Async
    @EventListener
    public void userCreatedSuccessfullyEvent(final UserCreatedSuccessfullyEvent event) {
        this.metricsPublisher.userCreatedSuccessfullyEvent(event);
    }

    @Async
    @EventListener
    public void failedToCreateUserEvent(final FailedToCreateUserEvent event) {
        this.metricsPublisher.failedToCreateUserEvent(event);
    }

    @Async
    @EventListener
    public void actionRunTimerEvent(final ActionRunTimerEvent event) {
        this.metricsPublisher.actionRunTimerEvent(event);
    }

}
