package com.example.java.metrics.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public final class User {
    private final String id;
    private final String username;
    private final String password;
    private final Collection<AccessProfile> accessProfile;

    public User(
            final String id,
            final String username,
            final String password,
            final Collection<AccessProfile> accessProfile
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accessProfile = Objects.requireNonNullElseGet(accessProfile, ArrayList::new);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Collection<AccessProfile> getAccessProfile() {
        return Collections.unmodifiableCollection(accessProfile);
    }

}
