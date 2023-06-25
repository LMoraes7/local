package com.example.java.metrics.infrastructure.database.postgres.converter;

import com.example.java.metrics.domain.model.AccessProfile;
import com.example.java.metrics.domain.model.User;
import com.example.java.metrics.infrastructure.database.postgres.entity.AccessProfileEntity;
import com.example.java.metrics.infrastructure.database.postgres.entity.UserEntity;
import com.example.java.metrics.infrastructure.database.postgres.wrapper.UserWithAcessProfileWrapper;
import com.example.java.metrics.infrastructure.security.vo.CustomGrantedAuthority;
import com.example.java.metrics.infrastructure.security.vo.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public final class ConverterHelper {

    public static UserEntity domainToEntity(final User user) {
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAccessProfile()
                        .stream()
                        .map(ConverterHelper::domainToEntity)
                        .toList()
        );
    }

    public static User entityToDomain(final UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getAccessProfileEntities()
                        .stream()
                        .map(ConverterHelper::entityToDomain)
                        .toList()
        );
    }

    public static UserDetails entityWrapperToUserDetails(final Collection<UserWithAcessProfileWrapper> userEntities) {
        final var first = userEntities.stream().findFirst().get();
        final var customGrantedAuthority = userEntities
                .stream()
                .map(it -> new CustomGrantedAuthority(it.getAccessProfileId(), it.getValue()))
                .toList();

        return new CustomUserDetails(
                first.getUserId(),
                first.getUsername(),
                first.getPassword(),
                customGrantedAuthority
        );
    }

    public static AccessProfileEntity domainToEntity(final AccessProfile accessProfile) {
        return new AccessProfileEntity(
                accessProfile.getId(),
                accessProfile.getValue()
        );
    }

    public static AccessProfile entityToDomain(final AccessProfileEntity accessProfileEntity) {
        return new AccessProfile(
                accessProfileEntity.getId(),
                accessProfileEntity.getValue()
        );
    }

}
