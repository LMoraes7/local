package com.github.lmoraes.recruitment.repository.employee.recruiter;

import com.github.lmoraes.recruitment.domain.model.employee.Recruiter;

import java.util.Optional;

public interface RecruiterRepository {
    Optional<Recruiter> findLightById(final String id);
}
