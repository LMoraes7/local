package com.github.lmoraes.recruitment.usecase.selection.process.dto;

import com.github.lmoraes.recruitment.domain.model.selective.process.Position;

import java.util.Collections;
import java.util.List;

public final class SelectionProcessDto {
    private final String title;
    private final String description;
    private final Position position;
    private final List<String> responsibilities;
    private final List<String> requirements;
    private final List<String> additionalInformations;
    private final List<NewStepDto> stepsDto;

    public SelectionProcessDto(
            final String title,
            final String description,
            final Position position,
            final List<String> responsibilities,
            final List<String> requirements,
            final List<String> additionalInformations,
            final List<NewStepDto> stepsDto
    ) {
        this.title = title;
        this.description = description;
        this.position = position;
        this.responsibilities = responsibilities;
        this.requirements = requirements;
        this.additionalInformations = additionalInformations;
        this.stepsDto = stepsDto;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Position getPosition() {
        return position;
    }

    public List<String> getResponsibilities() {
        return Collections.unmodifiableList(responsibilities);
    }

    public List<String> getRequirements() {
        return Collections.unmodifiableList(requirements);
    }

    public List<String> getAdditionalInformations() {
        return Collections.unmodifiableList(additionalInformations);
    }

    public List<NewStepDto> getStepsDto() {
        return stepsDto;
    }

}
