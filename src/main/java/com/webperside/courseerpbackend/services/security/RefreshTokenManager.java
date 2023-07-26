package com.webperside.courseerpbackend.services.security;

import com.webperside.courseerpbackend.models.dto.RefreshTokenDto;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.properties.security.SecurityProperties;
import com.webperside.courseerpbackend.services.base.TokenGenerator;
import com.webperside.courseerpbackend.services.base.TokenReader;
import com.webperside.courseerpbackend.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class RefreshTokenManager implements TokenGenerator<RefreshTokenDto>, TokenReader<Claims> {

    private final SecurityProperties securityProperties;

    @Override
    public String generate(RefreshTokenDto obj) {
        final User user = obj.getUser();

        Claims claims = Jwts.claims();
        claims.put("email", user.getEmail());
        claims.put("type", "REFRESH_TOKEN");

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getRefreshTokenValidityTime(obj.isRememberMe()));

        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public Claims read(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
