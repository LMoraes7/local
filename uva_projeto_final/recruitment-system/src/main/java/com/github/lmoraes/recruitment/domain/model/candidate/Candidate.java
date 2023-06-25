package com.github.lmoraes.recruitment.domain.model.candidate;

import com.github.lmoraes.recruitment.domain.model.application.Application;
import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;
import com.github.lmoraes.recruitment.domain.model.vo.AccessCredentials;
import com.github.lmoraes.recruitment.domain.model.vo.Pagination;
import com.github.lmoraes.recruitment.domain.model.vo.PersonalData;
import com.github.lmoraes.recruitment.exception.BusinessException;
import com.github.lmoraes.recruitment.exception.NotFoundException;
import com.github.lmoraes.recruitment.exception.PermissionDeniedException;
import com.github.lmoraes.recruitment.repository.application.ApplicationRepository;

import java.util.List;
import java.util.Objects;

import static com.github.lmoraes.recruitment.domain.model.selective.process.Status.IN_PROGRESS;
import static com.github.lmoraes.recruitment.usecase.application.conveter.ConverterHelper.buildApplication;

public class Candidate {
    private final String id;
    private final PersonalData personalData;
    private final AccessCredentials accessCredentials;

    public Candidate(
            final String id,
            final PersonalData personalData,
            final AccessCredentials accessCredentials
    ) {
        this.id = id;
        this.personalData = personalData;
        this.accessCredentials = accessCredentials;
    }

    public String getId() {
        return id;
    }

    public Application applyForTheSelectionProcess(
            final SelectiveProcess selectiveProcess,
            final ApplicationRepository applicationRepository
    ) {
        if (selectiveProcess.getStatus() != IN_PROGRESS)
            throw new BusinessException();

        final var application = buildApplication(this, selectiveProcess);
        applicationRepository.register(application);

        return application;
    }

    public void closeApplication(
            final Application application,
            final ApplicationRepository applicationRepository
    ) {
        if (!Objects.equals(application.getCandidate().getId(), this.id))
            throw new PermissionDeniedException(Candidate.class, this.id);

        application.close(applicationRepository);
    }

    public List<Application> getApplicationsPaginated(
            final Pagination pagination,
            final ApplicationRepository applicationRepository
    ) {
        return applicationRepository.getAllLightApplicationsOfACandidateById(this.id, pagination);
    }

    public Application getSpecificApplication(
            final String applicationId,
            final ApplicationRepository applicationRepository
    ) {
        return applicationRepository.getByIdAndCandidateId(applicationId, this.id)
                .orElseThrow(() -> new NotFoundException(Application.class, applicationId));
    }

}
