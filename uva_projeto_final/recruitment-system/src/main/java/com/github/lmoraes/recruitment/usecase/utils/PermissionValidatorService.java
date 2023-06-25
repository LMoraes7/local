package com.github.lmoraes.recruitment.usecase.utils;

import com.github.lmoraes.recruitment.domain.model.authenticable.Authenticable;
import com.github.lmoraes.recruitment.domain.model.employee.Employee;
import com.github.lmoraes.recruitment.domain.model.profile.Function;
import com.github.lmoraes.recruitment.exception.PermissionDeniedException;
import org.springframework.stereotype.Service;

@Service
public final class PermissionValidatorService {

    public void validate(final String permission, final Authenticable authenticable) {
        for (final var profile : authenticable.getAccessCredentials().getProfiles()) {
            if (profile.getFunctions().contains(new Function("", permission)))
                return;
        }

        throw new PermissionDeniedException(Authenticable.class, authenticable.getAccessCredentials().getCode());
    }

}
