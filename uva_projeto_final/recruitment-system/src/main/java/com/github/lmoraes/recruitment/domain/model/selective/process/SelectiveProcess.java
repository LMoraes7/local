package com.github.lmoraes.recruitment.domain.model.selective.process;

import com.github.lmoraes.recruitment.domain.model.application.Application;
import com.github.lmoraes.recruitment.domain.model.step.Step;
import com.github.lmoraes.recruitment.domain.model.vo.Responsible;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.github.lmoraes.recruitment.utils.IdentifierGeneratorService.generateIdentifierForSelectionProcess;

public final class SelectiveProcess {
    private final String id;
    private final String title;
    private final String description;
    private final Position position;
    private final List<String> responsibilities;
    private final List<String> requirements;
    private final List<String> additionalInformations;
    private final Status status;
    private final List<Responsible> responsible;
    private final List<Step> steps;
    private final List<Application> applications;

    public SelectiveProcess(
            final String title,
            final String description,
            final Position position,
            final List<String> responsibilities,
            final List<String> requirements,
            final List<String> additionalInformations,
            final List<Responsible> responsible
    ) {
        this.id = generateIdentifierForSelectionProcess();
        this.title = title;
        this.description = description;
        this.position = position;
        this.responsibilities = responsibilities;
        this.requirements = requirements;
        this.additionalInformations = additionalInformations;
        this.status = Status.IN_PROGRESS;
        this.responsible = responsible;
        this.steps = new ArrayList<>();
        this.applications = new ArrayList<>();
    }

    public Status getStatus() {
        return status;
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    public void addSteps(final List<Step> steps) {
        this.steps.addAll(steps);
    }

}
