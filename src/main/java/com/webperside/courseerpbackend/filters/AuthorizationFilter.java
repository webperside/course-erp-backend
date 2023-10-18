package com.webperside.courseerpbackend.filters;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.services.security.AccessTokenManager;
import com.webperside.courseerpbackend.services.security.AuthBusinessService;

import static com.webperside.courseerpbackend.constants.TokenConstants.PREFIX;
import static com.webperside.courseerpbackend.constants.RequestConstants.USER_ID;
import static com.webperside.courseerpbackend.constants.RequestConstants.USER_LANGUAGE;

import com.webperside.courseerpbackend.utils.RequestDataStorage;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;


@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {

    private final AccessTokenManager accessTokenManager;
    private final AuthBusinessService authBusinessService;
    private final RequestDataStorage requestDataStorage;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        requestDataStorage.setUserId(request.getHeader(USER_ID));
        requestDataStorage.setUserLanguage(request.getHeader(USER_LANGUAGE));

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        try {
            if (Objects.nonNull(token) && token.startsWith(PREFIX)) {
                authBusinessService.setAuthentication(
                        accessTokenManager.getEmail(
                                token.substring(7)
                        )
                );
            }
        } catch (BaseException | JwtException ex) {
            log.warn(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }
}
