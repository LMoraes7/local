package com.example.java.metrics.infrastructure.database.postgres.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public final class UserEntity {
    private final String id;
    private final String username;
    private final String password;
    private final Collection<AccessProfileEntity> accessProfileEntities;

    public UserEntity(
            final String id,
            final String username,
            final String password,
            final Collection<AccessProfileEntity> accessProfileEntities
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accessProfileEntities = Objects.requireNonNullElseGet(accessProfileEntities, ArrayList::new);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }


    public String getPassword() {
        return this.password;
    }

    public Collection<AccessProfileEntity> getAccessProfileEntities() {
        return Collections.unmodifiableCollection(this.accessProfileEntities);
    }

}
