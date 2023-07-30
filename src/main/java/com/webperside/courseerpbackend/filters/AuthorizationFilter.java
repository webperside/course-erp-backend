package com.webperside.courseerpbackend.filters;

import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.security.LoggedInUserDetails;
import com.webperside.courseerpbackend.services.security.AccessTokenManager;
import com.webperside.courseerpbackend.services.user.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private final AccessTokenManager accessTokenManager;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (Objects.nonNull(token) && token.startsWith("Bearer")) {
            final String accessToken = token.substring(7);

            Claims claims = accessTokenManager.read(accessToken);
            String email = claims.get("email", String.class);

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())
            );
        }

        filterChain.doFilter(request, response);
    }
}
