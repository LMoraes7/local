package com.github.lmoraes.recruitment.domain.model.step.test;

import com.github.lmoraes.recruitment.domain.model.step.InfoStep;
import com.github.lmoraes.recruitment.domain.model.step.InfoStepApplication;
import com.github.lmoraes.recruitment.domain.model.step.StepApplication;
import com.github.lmoraes.recruitment.domain.model.step.test.question.Question;

import java.util.ArrayList;
import java.util.List;

public final class Test implements StepApplication {
    private final InfoStep infoStep;
    private final InfoStepApplication infoStepApplication;
    private final List<Question> questions;

    public Test(final InfoStep infoStep) {
        this.infoStep = infoStep;
        this.infoStepApplication = null;
        this.questions = new ArrayList<>();
    }

    public Test(
            final InfoStep infoStep,
            final InfoStepApplication infoStepApplication
    ) {
        this.infoStep = infoStep;
        this.infoStepApplication = infoStepApplication;
        this.questions = new ArrayList<>();
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
