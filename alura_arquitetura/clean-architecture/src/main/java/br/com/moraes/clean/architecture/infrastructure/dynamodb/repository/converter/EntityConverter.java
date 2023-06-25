package br.com.moraes.clean.architecture.infrastructure.dynamodb.repository.converter;

public interface EntityConverter<T, R> {
    R toEntity(T domain);

    T toDomain(R entity);
}
