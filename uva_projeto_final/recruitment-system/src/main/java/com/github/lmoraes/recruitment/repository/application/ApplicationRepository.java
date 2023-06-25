package com.github.lmoraes.recruitment.repository.application;

import com.github.lmoraes.recruitment.domain.model.application.Application;
import com.github.lmoraes.recruitment.domain.model.application.Status;
import com.github.lmoraes.recruitment.domain.model.vo.Pagination;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository {
    void register(final Application application);
    List<Application> getAllLightApplicationsOfACandidateById(final String candidateId, final Pagination pagination);
    int updateStatusById(final String applicationId, final Status status);
    Optional<Application> getByIdAndCandidateId(final String applicationId, final String candidateId);
    Optional<Application> getById(final String applicationId);
}
