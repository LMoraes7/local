package com.example.java.metrics.infrastructure.security.service;

import com.example.java.metrics.application.credential.CredentialAccessService;
import com.example.java.metrics.domain.model.AccessProfile;
import com.example.java.metrics.domain.model.User;
import com.example.java.metrics.domain.vo.CredentialAccess;
import com.example.java.metrics.infrastructure.security.vo.AccessToken;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public final class JwtAccessTokenService implements CredentialAccessService {

    private final Key key;
    private final String expiration;

    public JwtAccessTokenService(
            final Key key,
            @Value("${api.jwt.expiration}")
            final String expiration
    ) {
        this.key = key;
        this.expiration = expiration;
    }

    @Override
    public CredentialAccess generateCredentialAccess(final User user) {
        final var now = new Date();
        final var expirationDate = new Date(now.getTime() + SECONDS.toMillis(Long.parseLong(expiration)));

        final String acessToken = Jwts.builder()
                .setIssuer("api-java-metrics")
                .setSubject(user.getId())
                .setAudience(user.getUsername())
                .setExpiration(expirationDate)
                .setIssuedAt(now)
                .claim("scopes", user.getAccessProfile().stream().map(AccessProfile::getValue).toList())
                .signWith(key)
                .compact();

        return new AccessToken(
                "Bearer",
                acessToken,
                MILLISECONDS.toMinutes(now.getTime()),
                MILLISECONDS.toMinutes(expirationDate.getTime())
        );
    }

    @Override
    public String getOwnerIdentifier(final String hash) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(hash).getBody().getSubject();
    }

    @Override
    public boolean credentialAccessIsValid(final String hash) {
        if (hash == null)
            return false;

        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(hash);
            return true;
        } catch (final JwtException ex) {
            return false;
        }
    }

}
