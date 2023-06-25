package com.github.lmoraes.recruitment.usecase.selection.process.converter;

import com.github.lmoraes.recruitment.domain.model.employee.Recruiter;
import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;
import com.github.lmoraes.recruitment.domain.model.step.InfoStep;
import com.github.lmoraes.recruitment.domain.model.step.Step;
import com.github.lmoraes.recruitment.domain.model.vo.Responsible;
import com.github.lmoraes.recruitment.usecase.selection.process.dto.SelectionProcessDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public final class ConverterHelper {

    public static SelectiveProcess buildSelectionProcess(
            final SelectionProcessDto selectionProcessDto,
            final Recruiter recruiter
    ) {
        final var selectionProcess = new SelectiveProcess(
                selectionProcessDto.getTitle(),
                selectionProcessDto.getDescription(),
                selectionProcessDto.getPosition(),
                selectionProcessDto.getResponsibilities(),
                selectionProcessDto.getRequirements(),
                selectionProcessDto.getAdditionalInformations(),
                Collections.singletonList(
                        new Responsible(
                                recruiter.getId(),
                                recruiter.getPersonalData().getName(),
                                LocalDate.now()
                        )
                )
        );

        final var steps = new ArrayList<Step>();
        for (final var it : selectionProcessDto.getStepsDto()) {
            try {
                final var constructor = it.getType().getClassType().getConstructor(InfoStep.class);
                final var step = constructor.newInstance(
                        new InfoStep(
                                it.getTitle(),
                                it.getDescription(),
                                it.getDeadline(),
                                it.getType()
                        )
                );
                steps.add(step);
            } catch (final Exception exception) {
                throw new RuntimeException(exception);
            }
        }

        selectionProcess.addSteps(steps);

        return selectionProcess;
    }

}
