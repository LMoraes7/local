package com.github.lmoraes.recruitment.domain.model.step;

import com.github.lmoraes.recruitment.domain.model.step.interview.Interview;
import com.github.lmoraes.recruitment.domain.model.step.test.Test;
import com.github.lmoraes.recruitment.domain.model.step.upload.UploadFile;

public enum Type {
    PORTUGUESE_TEST {
        @Override
        public Class<? extends Step> getClassType() {
            return Test.class;
        }
    },
    MATHEMATICS_TEST {
        @Override
        public Class<? extends Step> getClassType() {
            return Test.class;
        }
    },
    VIDEO_PRESENTATION {
        @Override
        public Class<? extends Step> getClassType() {
            return UploadFile.class;
        }
    },
    SUBMISSION_RESUME {
        @Override
        public Class<? extends Step> getClassType() {
            return UploadFile.class;
        }
    },
    INTERVIEW {
        @Override
        public Class<? extends Step> getClassType() {
            return Interview.class;
        }
    };

    public abstract Class<? extends Step> getClassType();

}
