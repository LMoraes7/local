package com.github.lmoraes.recruitment.utils;

import java.util.UUID;

public final class IdentifierGeneratorService {
    private static final String SELECTION_PROCESS_PREFIX = "SPR-";
    private static final String STEP_PREFIX = "STP-";
    private static final String APPLICATION_PREFIX = "APP-";
    private static final String SPLIT_PREFIX = "-";

    public static String generateIdentifierForSelectionProcess() {
        return SELECTION_PROCESS_PREFIX + generateUUID();
    }

    public static String generateIdentifierForStep() {
        return STEP_PREFIX + generateUUID();
    }

    public static String generateIdentifierForApplication() {
        return APPLICATION_PREFIX + generateUUID();
    }

    private static String generateUUID() {
        final var split = UUID.randomUUID().toString().split(SPLIT_PREFIX);
        return split[1] + split[3];
    }

}
