package com.github.lmoraes.recruitment.domain.model.step.test.question;

import java.util.List;

public final class Question {
    private final String id;
    private final String description;
    private final Discipline discipline;
    private final List<Answer> answers;

    public Question(
            final String id,
            final String description,
            final Discipline discipline,
            final List<Answer> answers
    ) {
        this.id = id;
        this.description = description;
        this.discipline = discipline;
        this.answers = answers;
    }

}
