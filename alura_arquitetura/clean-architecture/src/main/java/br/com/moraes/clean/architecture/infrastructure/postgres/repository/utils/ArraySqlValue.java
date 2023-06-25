package br.com.moraes.clean.architecture.infrastructure.postgres.repository.utils;

import org.springframework.jdbc.core.StatementCreatorUtils;
import org.springframework.jdbc.support.SqlValue;

import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Objects;

public final class ArraySqlValue implements SqlValue {
    private final Object[] arr;
    private final String dbTypeName;

    public static ArraySqlValue create(final Object[] arr) {
        return new ArraySqlValue(arr, determineDbTypeName(arr));
    }

    public static ArraySqlValue create(final Object[] arr, final String dbTypeName) {
        return new ArraySqlValue(arr, dbTypeName);
    }

    private ArraySqlValue(final Object[] arr, final String dbTypeName) {
        this.arr = Objects.requireNonNull(arr);
        this.dbTypeName = Objects.requireNonNull(dbTypeName);
    }

    @Override
    public void setValue(final PreparedStatement ps, final int paramIndex) throws SQLException {
        final var arrayValue = ps.getConnection().createArrayOf(dbTypeName, arr);
        ps.setArray(paramIndex, arrayValue);
    }

    @Override
    public void cleanup() {}

    private static String determineDbTypeName(final Object[] arr) {
        final int sqlParameterType =
                StatementCreatorUtils.javaTypeToSqlParameterType(arr.getClass().getComponentType());
        final var jdbcTypeToUse = JDBCType.valueOf(sqlParameterType);
        return jdbcTypeToUse.getName().toLowerCase(Locale.US);
    }
}
