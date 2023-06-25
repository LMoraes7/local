package com.example.java.metrics.infrastructure.database.postgres.repository;

import com.example.java.metrics.domain.model.User;
import com.example.java.metrics.domain.repository.UserRepository;
import com.example.java.metrics.infrastructure.database.postgres.entity.UserEntity;
import com.example.java.metrics.infrastructure.database.postgres.wrapper.UserWithAcessProfileWrapper;
import com.example.java.metrics.infrastructure.security.repository.UserDetailsRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.java.metrics.infrastructure.database.postgres.converter.ConverterHelper.entityToDomain;
import static com.example.java.metrics.infrastructure.database.postgres.converter.ConverterHelper.entityWrapperToUserDetails;

@Repository
public class UserRepositoryPostgres implements UserRepository, UserDetailsRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryPostgres(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findById(final String id) {
        try {
            final var userEntity = this.jdbcTemplate.queryForObject(
                    "select u.id, u.username from users u where u.id = ?",
                    (rs, index) -> new UserEntity(rs.getString("id"), rs.getString("username"), null, null),
                    id
            );

            if (userEntity == null)
                return Optional.empty();

            return Optional.of(entityToDomain(userEntity));
        } catch (final EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public boolean save(final User user) {
        final int update = this.jdbcTemplate.update(
                "insert into users(id, username, password) values (?, ?, ?)",
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );

        return update == 1;
    }

    @Override
    public boolean existsByUsername(final String username) {
        final var count = this.jdbcTemplate.queryForObject(
                "select count(*) from users u where u.username = ?",
                Integer.class,
                username
        );
        return count == 1;
    }

    @Override
    public Optional<UserDetails> findByIdWithAccessProfile(final String id) {
        final var userEntities = this.jdbcTemplate.query(
                "select u.id as user_id, u.username, ap.id as access_profile_id, ap.name from users u " +
                        "left join users_access_profiles uap on u.id = uap.user_id " +
                        "left join access_profiles ap on ap.id = uap.access_profile_id " +
                        "where u.id = ?",
                (rs, index) -> new UserWithAcessProfileWrapper(
                        rs.getString("user_id"),
                        rs.getString("username"),
                        null,
                        rs.getString("access_profile_id"),
                        rs.getString("name")
                ),
                id
        );

        if (userEntities.isEmpty())
            return Optional.empty();

        return Optional.of(entityWrapperToUserDetails(userEntities));
    }

    @Override
    public Optional<UserDetails> findByUsername(final String username) {
        final var userEntities = this.jdbcTemplate.query(
                "select u.id as user_id, u.username, u.password, ap.id as access_profile_id, ap.name from users u " +
                        "left join users_access_profiles uap on u.id = uap.user_id " +
                        "left join access_profiles ap on ap.id = uap.access_profile_id " +
                        "where u.username = ?",
                (rs, index) -> new UserWithAcessProfileWrapper(
                        rs.getString("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("access_profile_id"),
                        rs.getString("name")
                ),
                username
        );

        if (userEntities.isEmpty())
            return Optional.empty();

        return Optional.of(entityWrapperToUserDetails(userEntities));
    }

}
