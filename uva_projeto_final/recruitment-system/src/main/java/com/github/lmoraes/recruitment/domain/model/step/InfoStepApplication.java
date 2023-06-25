package com.github.lmoraes.recruitment.domain.model.step;

import com.github.lmoraes.recruitment.domain.model.step.feedback.Feedback;

import java.time.LocalDate;

public final class InfoStepApplication {
    private final StatusStepApplication statusStepApplication;
    private final LocalDate releaseDate;
    private final Feedback feedback;

    public InfoStepApplication(
            final StatusStepApplication statusStepApplication,
            final LocalDate releaseDate
    ) {
        this.statusStepApplication = statusStepApplication;
        this.releaseDate = releaseDate;
        this.feedback = null;
    }

}
