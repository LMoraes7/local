package com.github.lmoraes.recruitment.domain.model.employee;

import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;
import com.github.lmoraes.recruitment.domain.model.vo.AccessCredentials;
import com.github.lmoraes.recruitment.domain.model.vo.PersonalData;
import com.github.lmoraes.recruitment.repository.selection.process.SelectionProcessRepository;
import com.github.lmoraes.recruitment.usecase.selection.process.dto.SelectionProcessDto;

import static com.github.lmoraes.recruitment.usecase.selection.process.converter.ConverterHelper.buildSelectionProcess;

public final class Recruiter extends Employee {

    public Recruiter(
            final String id,
            final PersonalData personalData,
            final AccessCredentials accessCredentials
    ) {
        super(id, personalData, accessCredentials);
    }

    public SelectiveProcess createSelectionProcess(
            final SelectionProcessDto selectionProcessDto,
            final SelectionProcessRepository selectionProcessRepository
    ) {
        final var selectiveProcess = buildSelectionProcess(selectionProcessDto, this);
        selectionProcessRepository.register(selectiveProcess);

        return selectiveProcess;
    }

    public void releaseStep(

    ) {

    }

    public void registerFeedback() {

    }

    public void closeSelectiveProcess() {

    }

}
