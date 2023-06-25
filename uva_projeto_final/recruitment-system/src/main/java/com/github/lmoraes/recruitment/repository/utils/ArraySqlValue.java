package com.github.lmoraes.recruitment.repository.utils;

import org.springframework.jdbc.core.StatementCreatorUtils;
import org.springframework.jdbc.support.SqlValue;

import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public final class ArraySqlValue<T> implements SqlValue {

    public static <T> ArraySqlValue<T> invoke(final T[] array, final String dbTypeName) {
        return new ArraySqlValue<>(array, dbTypeName);
    }

    public static <T> ArraySqlValue<T> invoke(final T[] array) {
        return new ArraySqlValue<>(array, determineDbTypeName(array));
    }

    private static <T> String determineDbTypeName(final T[] array) {
        final var type = StatementCreatorUtils.javaTypeToSqlParameterType(array.getClass().componentType());
        return JDBCType.valueOf(type).getName().toLowerCase(Locale.US);
    }

    private final T[] array;
    private final String dbTypeName;

    private ArraySqlValue(final T[] array, final String dbTypeName) {
        this.array = array;
        this.dbTypeName = dbTypeName;
    }

    @Override
    public void setValue(final PreparedStatement ps, final int paramIndex) throws SQLException {
        final var arrayOf = ps.getConnection().createArrayOf(dbTypeName, array);
        ps.setArray(paramIndex, arrayOf);
    }

    @Override
    public void cleanup() {}

    public T[] getArray() {
        return array;
    }

}
