package com.github.lmoraes.recruitment.usecase.application;

import com.github.lmoraes.recruitment.domain.model.application.Application;
import com.github.lmoraes.recruitment.domain.model.candidate.Candidate;
import com.github.lmoraes.recruitment.exception.NotFoundException;
import com.github.lmoraes.recruitment.repository.application.ApplicationRepository;
import com.github.lmoraes.recruitment.repository.candidate.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public final class ConsultSpecificApplicationUseCase {
    private static final String PERMISSION_REQUIRED = "FUNCTION_CONSULT_SPECIFIC_APPLICATION";

    private final CandidateRepository candidateRepository;
    private final ApplicationRepository applicationRepository;

    public ConsultSpecificApplicationUseCase(
            final CandidateRepository candidateRepository,
            final ApplicationRepository applicationRepository
    ) {
        this.candidateRepository = candidateRepository;
        this.applicationRepository = applicationRepository;
    }

    public Application execute(final String candidateId, final String applicationId) {
        final var candidate = this.candidateRepository.findLightById(candidateId)
                .orElseThrow(() -> new NotFoundException(Candidate.class, candidateId));

        return candidate.getSpecificApplication(applicationId, this.applicationRepository);
    }

}
