package com.github.lmoraes.recruitment.repository.candidate;

import com.github.lmoraes.recruitment.domain.model.candidate.Candidate;

import java.util.Optional;

public interface CandidateRepository {
    Optional<Candidate> findLightById(final String id);


}
