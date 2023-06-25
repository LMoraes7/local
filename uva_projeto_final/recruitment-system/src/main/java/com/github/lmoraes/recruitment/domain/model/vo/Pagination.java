package com.github.lmoraes.recruitment.domain.model.vo;

public final class Pagination {
    private final int page;
    private final int size;

    public Pagination(final int page, final int size) {
        this.page = page;
        this.size = size;
    }

}
