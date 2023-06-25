package com.github.lmoraes.recruitment.domain.model.step.interview;

import com.github.lmoraes.recruitment.domain.model.step.InfoStep;
import com.github.lmoraes.recruitment.domain.model.step.InfoStepApplication;
import com.github.lmoraes.recruitment.domain.model.step.StepApplication;

import java.time.LocalDateTime;

public final class Interview implements StepApplication {
    private final InfoStep infoStep;
    private final InfoStepApplication infoStepApplication;
    private final String linkInterview;
    private final LocalDateTime dateTime;

    public Interview(final InfoStep infoStep) {
        this.infoStep = infoStep;
        this.infoStepApplication = null;
        this.linkInterview = null;
        this.dateTime = null;
    }

    public Interview(
            final InfoStep infoStep,
            final InfoStepApplication infoStepApplication
    ) {
        this.infoStep = infoStep;
        this.infoStepApplication = infoStepApplication;
        this.linkInterview = null;
        this.dateTime = null;
    }

    @Override
    public InfoStep getInfoStep() {
        return infoStep;
    }

    @Override
    public InfoStepApplication getInfoStepApplication() {
        return infoStepApplication;
    }

}
