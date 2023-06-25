package com.github.lmoraes.recruitment.domain.model.step.test.question;

public final class Answer {
    private final String id;
    private final String description;
    private final boolean correct;

    public Answer(
            final String id,
            final String description,
            final boolean correct
    ) {
        this.id = id;
        this.description = description;
        this.correct = correct;
    }

}
