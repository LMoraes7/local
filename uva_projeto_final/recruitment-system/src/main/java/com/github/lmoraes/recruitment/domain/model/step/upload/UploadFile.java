package com.github.lmoraes.recruitment.domain.model.step.upload;

import com.github.lmoraes.recruitment.domain.model.step.InfoStep;
import com.github.lmoraes.recruitment.domain.model.step.InfoStepApplication;
import com.github.lmoraes.recruitment.domain.model.step.StepApplication;

public final class UploadFile implements StepApplication {
    private final InfoStep infoStep;
    private final InfoStepApplication infoStepApplication;
    private final byte[] file;
    private final FileType fileType;

    public UploadFile(final InfoStep infoStep) {
        this.infoStep = infoStep;
        this.infoStepApplication = null;
        this.file = null;
        this.fileType = null;
    }

    public UploadFile(
            final InfoStep infoStep,
            final InfoStepApplication infoStepApplication
    ) {
        this.infoStep = infoStep;
        this.infoStepApplication = infoStepApplication;
        this.file = null;
        this.fileType = null;
    }

    @Override
    public InfoStep getInfoStep() {
        return infoStep;
    }

    @Override
    public InfoStepApplication getInfoStepApplication() {
        return infoStepApplication;
    }

}
