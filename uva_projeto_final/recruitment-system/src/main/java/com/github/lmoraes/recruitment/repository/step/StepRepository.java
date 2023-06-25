package com.github.lmoraes.recruitment.repository.step;

import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;

public interface StepRepository {
    void register(final SelectiveProcess selectiveProcess);
}
