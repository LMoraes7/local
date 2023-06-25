package com.github.lmoraes.recruitment.usecase.application.conveter;

import com.github.lmoraes.recruitment.domain.model.application.Application;
import com.github.lmoraes.recruitment.domain.model.candidate.Candidate;
import com.github.lmoraes.recruitment.domain.model.selective.process.SelectiveProcess;
import com.github.lmoraes.recruitment.domain.model.step.InfoStep;
import com.github.lmoraes.recruitment.domain.model.step.InfoStepApplication;
import com.github.lmoraes.recruitment.domain.model.step.StatusStepApplication;
import com.github.lmoraes.recruitment.domain.model.step.StepApplication;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.github.lmoraes.recruitment.domain.model.step.StatusStepApplication.WAITING_EXECUTION;
import static com.github.lmoraes.recruitment.domain.model.step.StatusStepApplication.WAITING_RELEASE;

public final class ConverterHelper {

    public static Application buildApplication(
            final Candidate candidate,
            final SelectiveProcess selectiveProcess
    ) {
        final var application = new Application(candidate, selectiveProcess);

        final var stepsApplication = new ArrayList<StepApplication>();

        final var stepsSelectiveProcess = selectiveProcess.getSteps();
        for (int i = 0; i < stepsSelectiveProcess.size(); i++) {
            final var step = stepsSelectiveProcess.get(i);

            try {
                final var constructor = step.getInfoStep().getType().getClassType().getConstructor(
                        InfoStep.class,
                        InfoStepApplication.class
                );

                StatusStepApplication statusStepApplication;
                LocalDate releaseDate;
                if (i == 0) {
                    statusStepApplication = WAITING_EXECUTION;
                    releaseDate = LocalDate.now();
                }
                else {
                    statusStepApplication = WAITING_RELEASE;
                    releaseDate = null;
                }

                final var stepApplication = (StepApplication) constructor.newInstance(
                        step.getInfoStep(),
                        new InfoStepApplication(statusStepApplication, releaseDate)
                );

                stepsApplication.add(stepApplication);
            } catch (final Exception exception) {
                throw new RuntimeException(exception);
            }
        }

        application.addStepsApplication(stepsApplication);

        return application;
    }

}
