package com.github.lmoraes.recruitment.domain.model.vo;

import java.time.LocalDate;

public final class Responsible {
    private final String id;
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Responsible(
            final String id,
            final String name,
            final LocalDate startDate
    ) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = null;
    }

    public Responsible(
            final String id,
            final String name,
            final LocalDate startDate,
            final LocalDate endDate
    ) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
