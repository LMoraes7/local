package com.github.lmoraes.recruitment.usecase.application;

import com.github.lmoraes.recruitment.domain.model.application.Application;
import com.github.lmoraes.recruitment.domain.model.candidate.Candidate;
import com.github.lmoraes.recruitment.exception.NotFoundException;
import com.github.lmoraes.recruitment.repository.candidate.CandidateRepository;
import com.github.lmoraes.recruitment.usecase.utils.PermissionValidatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class ConsultAllApplicationsUseCase {
    private static final String PERMISSION_REQUIRED = "FUNCTION_CONSULT_ALL_APPLICATIONS";

    private final CandidateRepository candidateRepository;
    private final PermissionValidatorService permissionValidatorService;

    public ConsultAllApplicationsUseCase(
            final CandidateRepository candidateRepository,
            final PermissionValidatorService permissionValidatorService
    ) {
        this.candidateRepository = candidateRepository;
        this.permissionValidatorService = permissionValidatorService;
    }

    public List<Application> execute(final String candidateId) {
        final var candidate = this.candidateRepository.findLightById(candidateId)
                .orElseThrow(() -> new NotFoundException(Candidate.class, candidateId));

        this.permissionValidatorService.validate(PERMISSION_REQUIRED, candidate);

        return candidate.getLightApplications();
    }

}
