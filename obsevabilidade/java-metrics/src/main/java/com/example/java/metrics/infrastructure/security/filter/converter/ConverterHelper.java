package com.example.java.metrics.infrastructure.security.filter.converter;

import com.example.java.metrics.domain.model.AccessProfile;
import com.example.java.metrics.domain.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public final class ConverterHelper {

    public static User userDetailsToDomain(final String id, final UserDetails userDetails) {
        return new User(
                id,
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getAuthorities().stream().map(it -> new AccessProfile(null, it.getAuthority())).toList()
        );
    }

}
