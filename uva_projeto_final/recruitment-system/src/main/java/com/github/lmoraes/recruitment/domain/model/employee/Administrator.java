package com.github.lmoraes.recruitment.domain.model.employee;

import com.github.lmoraes.recruitment.domain.model.vo.AccessCredentials;
import com.github.lmoraes.recruitment.domain.model.vo.PersonalData;

public final class Administrator extends Employee {

    public Administrator(
            final String id,
            final PersonalData personalData,
            final AccessCredentials accessCredentials
    ) {
        super(id, personalData, accessCredentials);
    }

    public void registerAccessProfile() {

    }

    public void registerRecruiter() {

    }

}
