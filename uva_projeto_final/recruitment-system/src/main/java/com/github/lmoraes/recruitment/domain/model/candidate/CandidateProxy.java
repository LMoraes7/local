package com.github.lmoraes.recruitment.domain.model.candidate;

import com.github.lmoraes.recruitment.domain.model.application.Application;
import com.github.lmoraes.recruitment.domain.model.vo.AccessCredentials;
import com.github.lmoraes.recruitment.domain.model.vo.PersonalData;
import com.github.lmoraes.recruitment.repository.application.ApplicationRepository;

import java.util.Collections;
import java.util.List;

public final class CandidateProxy extends Candidate {
    private final ApplicationRepository applicationRepository;

    public CandidateProxy(
            final String id,
            final PersonalData personalData,
            final AccessCredentials accessCredentials,
            final List<Application> applications,
            final ApplicationRepository applicationRepository
    ) {
        super(id, personalData, accessCredentials, applications);
        this.applicationRepository = applicationRepository;
    }

    @Override
    public List<Application> getLightApplications() {
        if (super.applications != null)
            return super.getLightApplications();

        final var lightApplications = this.applicationRepository.getAllLightApplicationsOfACandidateById(super.id);
        return Collections.unmodifiableList(lightApplications);
    }

}
