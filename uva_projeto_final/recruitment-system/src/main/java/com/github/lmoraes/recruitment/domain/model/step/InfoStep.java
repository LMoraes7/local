package com.github.lmoraes.recruitment.domain.model.step;

import com.github.lmoraes.recruitment.utils.IdentifierGeneratorService;

public final class InfoStep {
    private final String id;
    private final String title;
    private final String description;
    private final Long deadline;
    private final Type type;

    public InfoStep(
            final String title,
            final String description,
            final Long deadline,
            final Type type
    ) {
        this.id = IdentifierGeneratorService.generateIdentifierForStep();
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

}
