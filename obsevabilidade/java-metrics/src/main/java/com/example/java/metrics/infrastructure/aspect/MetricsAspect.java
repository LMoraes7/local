package com.example.java.metrics.infrastructure.aspect;

import com.example.java.metrics.application.metrics.event.timer.ActionRunTimerEvent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Aspect
@Component
public final class MetricsAspect {

    private final ApplicationEventPublisher publisher;

    public MetricsAspect(final ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    @Around(value = "@annotation(timer)")
    public void timerJoinPoint(final ProceedingJoinPoint proceedingJoinPoint, final Timer timer) throws Throwable {
        var isActionPerformedSuccessfully = true;

        final long now = System.currentTimeMillis();
        try {
            proceedingJoinPoint.proceed();
        } catch (final Exception exception) {
            isActionPerformedSuccessfully = false;
            throw exception;
        } finally {
            long runtimeMeasurement = System.currentTimeMillis() - now;
            this.publisher.publishEvent(
                    new ActionRunTimerEvent(
                            timer.metric(),
                            timer.action(),
                            runtimeMeasurement,
                            MILLISECONDS,
                            isActionPerformedSuccessfully
                    )
            );
        }

    }

}
