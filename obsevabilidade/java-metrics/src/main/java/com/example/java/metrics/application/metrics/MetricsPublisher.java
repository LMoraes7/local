package com.example.java.metrics.application.metrics;

import com.example.java.metrics.application.metrics.event.login.FailedLoginEvent;
import com.example.java.metrics.application.metrics.event.login.LoginSuccessfullyEvent;
import com.example.java.metrics.application.metrics.event.timer.ActionRunTimerEvent;
import com.example.java.metrics.application.metrics.event.user.FailedToCreateUserEvent;
import com.example.java.metrics.application.metrics.event.user.UserCreatedSuccessfullyEvent;

public interface MetricsPublisher {
    void loginSuccessfullyEvent(final LoginSuccessfullyEvent event);
    void failedLoginEvent(final FailedLoginEvent event);
    void userCreatedSuccessfullyEvent(final UserCreatedSuccessfullyEvent event);
    void failedToCreateUserEvent(final FailedToCreateUserEvent event);
    void actionRunTimerEvent(final ActionRunTimerEvent event);
}
