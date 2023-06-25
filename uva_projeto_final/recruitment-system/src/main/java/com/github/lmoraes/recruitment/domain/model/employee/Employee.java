package com.github.lmoraes.recruitment.domain.model.employee;

import com.github.lmoraes.recruitment.domain.model.vo.AccessCredentials;
import com.github.lmoraes.recruitment.domain.model.vo.PersonalData;

public abstract class Employee {
    private final String id;
    private final PersonalData personalData;
    private final AccessCredentials accessCredentials;

    public Employee(
            final String id,
            final PersonalData personalData,
            final AccessCredentials accessCredentials
    ) {
        this.id = id;
        this.personalData = personalData;
        this.accessCredentials = accessCredentials;
    }

}
