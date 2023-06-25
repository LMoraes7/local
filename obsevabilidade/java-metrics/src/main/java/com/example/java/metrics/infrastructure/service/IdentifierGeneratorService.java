package com.example.java.metrics.infrastructure.service;

import com.example.java.metrics.application.generator.CourseIdentifierGenerator;
import com.example.java.metrics.application.generator.UserIdentifierGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public final class IdentifierGeneratorService implements UserIdentifierGenerator, CourseIdentifierGenerator {

    private static final String USER_PREFIX = "USR-";
    private static final String COURSE_PREFIX = "CRS-";
    private static final String SPLIT_PREFIX = "-";

    @Override
    public String generateIdentifierForCourse() {
        return USER_PREFIX + generateUUID();
    }

    @Override
    public String generateIdentifierForUser() {
        return COURSE_PREFIX + generateUUID();
    }

    private static String generateUUID() {
        final var split = UUID.randomUUID().toString().split(SPLIT_PREFIX);
        return split[1] + split[3];
    }

}
