package com.github.lmoraes.recruitment.domain.model.step.feedback;

import com.github.lmoraes.recruitment.domain.model.step.StepApplication;

import java.math.BigDecimal;

public final class Feedback {
    private final String id;
    private final Result result;
    private final BigDecimal score;
    private final String additionalInformation;
    private final StepApplication stepApplication;

    public Feedback(
            final String id,
            final Result result,
            final BigDecimal score,
            final String additionalInformation,
            final StepApplication stepApplication
    ) {
        this.id = id;
        this.result = result;
        this.score = score;
        this.additionalInformation = additionalInformation;
        this.stepApplication = stepApplication;
    }

}
