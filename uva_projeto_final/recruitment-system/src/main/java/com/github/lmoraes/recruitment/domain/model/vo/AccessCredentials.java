package com.github.lmoraes.recruitment.domain.model.vo;

import com.github.lmoraes.recruitment.domain.model.profile.Profile;

import java.util.List;

public final class AccessCredentials {
    private final String code;
    private final String password;
    private final List<Profile> profiles;

    public AccessCredentials(
            final String code,
            final String password,
            final List<Profile> profiles
    ) {
        this.code = code;
        this.password = password;
        this.profiles = profiles;
    }

}
