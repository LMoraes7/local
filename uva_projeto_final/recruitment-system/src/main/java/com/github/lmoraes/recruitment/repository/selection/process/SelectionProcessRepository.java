package com.github.lmoraes.recruitment.repository.selection.process;

import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;

import java.util.Optional;

public interface SelectionProcessRepository {
    void register(final SelectiveProcess selectiveProcess);
    Optional<SelectiveProcess> findLightById(final String id);
}
