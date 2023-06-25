package com.github.lmoraes.recruitment.usecase.selection.process;

import com.github.lmoraes.recruitment.domain.model.employee.Recruiter;
import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;
import com.github.lmoraes.recruitment.exception.NotFoundException;
import com.github.lmoraes.recruitment.repository.employee.recruiter.RecruiterRepository;
import com.github.lmoraes.recruitment.repository.selection.process.SelectionProcessRepository;
import com.github.lmoraes.recruitment.usecase.selection.process.dto.SelectionProcessDto;
import com.github.lmoraes.recruitment.usecase.utils.PermissionValidatorService;
import org.springframework.stereotype.Service;

@Service
public final class CreateSelectionProcessUseCase {
    private static final String PERMISSION_REQUIRED = "FUNCTION_CREATE_SELECTION_PROCESS";

    private final RecruiterRepository recruiterRepository;
    private final PermissionValidatorService permissionValidatorService;
    private final SelectionProcessRepository selectionProcessRepository;

    public CreateSelectionProcessUseCase(
            final RecruiterRepository recruiterRepository,
            final PermissionValidatorService permissionValidatorService,
            final SelectionProcessRepository selectionProcessRepository
    ) {
        this.recruiterRepository = recruiterRepository;
        this.permissionValidatorService = permissionValidatorService;
        this.selectionProcessRepository = selectionProcessRepository;
    }

    public SelectiveProcess execute(
            final String recruiterId,
            final SelectionProcessDto selectionProcessDto
    ) {
        final var recruiter = this.recruiterRepository.findLightById(recruiterId)
                .orElseThrow(() -> new NotFoundException(Recruiter.class, recruiterId));

        this.permissionValidatorService.validate(PERMISSION_REQUIRED, recruiter);
        return recruiter.createSelectionProcess(selectionProcessDto, this.selectionProcessRepository);
    }

}
