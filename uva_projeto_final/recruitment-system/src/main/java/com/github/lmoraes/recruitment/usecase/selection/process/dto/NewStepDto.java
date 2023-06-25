package com.github.lmoraes.recruitment.usecase.selection.process.dto;

import com.github.lmoraes.recruitment.domain.model.step.Type;

public final class NewStepDto {
    private final String title;
    private final String description;
    private final Long deadline;
    private final Type type;

    public NewStepDto(
            final String title,
            final String description,
            final Long deadline,
            final Type type
    ) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getDeadline() {
        return deadline;
    }

    public Type getType() {
        return type;
    }

}
