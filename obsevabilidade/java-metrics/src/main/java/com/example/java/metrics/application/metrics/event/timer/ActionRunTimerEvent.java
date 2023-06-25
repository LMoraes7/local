package com.example.java.metrics.application.metrics.event.timer;

import java.util.concurrent.TimeUnit;

public final class ActionRunTimerEvent {

    private final String metricName;
    private final String action;
    private final long measurement;
    private final TimeUnit timeUnit;
    private final Boolean isActionPerformedSuccessfully;

    public ActionRunTimerEvent(
            final String metricName,
            final String action,
            final long measurement,
            final TimeUnit timeUnit,
            final Boolean isActionPerformedSuccessfully
    ) {
        this.metricName = metricName;
        this.action = action;
        this.measurement = measurement;
        this.timeUnit = timeUnit;
        this.isActionPerformedSuccessfully = isActionPerformedSuccessfully;
    }

    public String getMetricName() {
        return metricName;
    }

    public String getAction() {
        return action;
    }

    public long getMeasurement() {
        return measurement;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public Boolean isActionPerformedSuccessfully() {
        return isActionPerformedSuccessfully;
    }

}
