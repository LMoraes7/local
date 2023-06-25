package com.github.lmoraes.recruitment.usecase.application;

import com.github.lmoraes.recruitment.domain.model.application.Application;
import com.github.lmoraes.recruitment.domain.model.candidate.Candidate;
import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;
import com.github.lmoraes.recruitment.exception.NotFoundException;
import com.github.lmoraes.recruitment.repository.application.ApplicationRepository;
import com.github.lmoraes.recruitment.repository.candidate.CandidateRepository;
import com.github.lmoraes.recruitment.repository.selection.process.SelectionProcessRepository;
import com.github.lmoraes.recruitment.usecase.utils.PermissionValidatorService;
import org.springframework.stereotype.Service;

@Service
public final class RegisterApplicationUseCase {
    private static final String PERMISSION_REQUIRED = "FUNCTION_REGISTER_APPLICATION";

    private final CandidateRepository candidateRepository;
    private final PermissionValidatorService permissionValidatorService;
    private final SelectionProcessRepository selectionProcessRepository;
    private final ApplicationRepository applicationRepository;

    public RegisterApplicationUseCase(
            final CandidateRepository candidateRepository,
            final PermissionValidatorService permissionValidatorService,
            final SelectionProcessRepository selectionProcessRepository,
            final ApplicationRepository applicationRepository
    ) {
        this.candidateRepository = candidateRepository;
        this.permissionValidatorService = permissionValidatorService;
        this.selectionProcessRepository = selectionProcessRepository;
        this.applicationRepository = applicationRepository;
    }

    public Application execute(final String candidateId, final String selectiveProcessId) {
        final var candidate = this.candidateRepository.findLightById(candidateId)
                .orElseThrow(() -> new NotFoundException(Candidate.class, candidateId));

        this.permissionValidatorService.validate(PERMISSION_REQUIRED, candidate);

        final var selectiveProcess = this.selectionProcessRepository.findLightById(selectiveProcessId)
                .orElseThrow(() -> new NotFoundException(SelectiveProcess.class, selectiveProcessId));

        return candidate.applyForTheSelectionProcess(selectiveProcess, this.applicationRepository);
    }

}
