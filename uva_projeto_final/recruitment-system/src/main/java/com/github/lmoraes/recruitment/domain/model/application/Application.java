package com.github.lmoraes.recruitment.domain.model.application;

import com.github.lmoraes.recruitment.domain.model.candidate.Candidate;
import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;
import com.github.lmoraes.recruitment.domain.model.step.StepApplication;
import com.github.lmoraes.recruitment.exception.NotFoundException;
import com.github.lmoraes.recruitment.repository.application.ApplicationRepository;

import java.util.ArrayList;
import java.util.List;

import static com.github.lmoraes.recruitment.domain.model.application.Status.CLOSED;
import static com.github.lmoraes.recruitment.domain.model.application.Status.IN_PROGRESS;
import static com.github.lmoraes.recruitment.utils.IdentifierGeneratorService.generateIdentifierForApplication;

public final class Application {
    private final String id;
    private Status status;
    private final Candidate candidate;
    private final SelectiveProcess selectiveProcess;
    private final List<StepApplication> stepsApplication;

    public Application(final Candidate candidate, final SelectiveProcess selectiveProcess) {
        this.id = generateIdentifierForApplication();
        this.status = IN_PROGRESS;
        this.candidate = candidate;
        this.selectiveProcess = selectiveProcess;
        this.stepsApplication = new ArrayList<>();
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void addStepsApplication(final List<StepApplication> stepsApplication) {
        this.stepsApplication.addAll(stepsApplication);
    }

    public void close(final ApplicationRepository applicationRepository) {
        int update = applicationRepository.updateStatusById(this.id, CLOSED);

        if (update != 1)
            throw new NotFoundException(Application.class, this.id);
    }

}
