package com.webperside.courseerpbackend.services.otp;

import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.properties.otp.OTPProperties;
import com.webperside.courseerpbackend.services.base.TokenGenerator;
import com.webperside.courseerpbackend.services.base.TokenReader;
import com.webperside.courseerpbackend.services.getters.IdGetter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class OTPProceedTokenManager implements TokenGenerator<User>, TokenReader<Claims>, IdGetter<Long> {

    private final OTPProperties otpProperties;

    @Override
    public String generate(User obj) {
        Claims claims = Jwts.claims();
        claims.put("type", "OTP_PROCEED_KEY");

        Date now = new Date();
        Date exp = new Date(now.getTime() + otpProperties.getValidityTime());


        return Jwts.builder()
                .setSubject(String.valueOf(obj.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    @Override
    public Claims read(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(otpProperties.getJwt().getSecretKey().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public Long getId(String token) {
        return Long.valueOf(read(token).getSubject());
    }
}
