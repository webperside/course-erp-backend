package com.webperside.courseerpbackend.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());

        System.out.println(request.getServletPath());

        filterChain.doFilter(request, response);

        System.out.println("test ishleyir");

    }
}
