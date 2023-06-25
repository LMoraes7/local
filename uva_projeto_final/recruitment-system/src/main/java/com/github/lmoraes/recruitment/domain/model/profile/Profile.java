package com.github.lmoraes.recruitment.domain.model.profile;

import java.util.List;

public final class Profile {
    private final String id;
    private final String name;
    private final List<Function> functions;

    public Profile(
            final String id,
            final String name,
            final List<Function> functions
    ) {
        this.id = id;
        this.name = name;
        this.functions = functions;
    }

}
