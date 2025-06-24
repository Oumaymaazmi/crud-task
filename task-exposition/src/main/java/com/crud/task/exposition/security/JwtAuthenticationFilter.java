package com.crud.task.exposition.security;

import com.crud.task.domain.exception.FunctionalException;
import com.crud.task.exposition.security.authentification.AppUserDetails;
import com.crud.task.exposition.security.authentification.UserAuthenticateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private UserAuthenticateService userAuthenticateService;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        String jwt = getJwtFromRequest(request);
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            if (!StringUtils.hasText(jwt)) {
                throw new FunctionalException("JWT not present");
            }
            if (SecurityContextHolder.getContext() != null
                    && SecurityContextHolder.getContext().getAuthentication() != null
                    && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
                Jwt principal = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
                String email = principal.getClaim("sub");
                AppUserDetails userDetails = userAuthenticateService.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new FunctionalException("No authentication found");
            }
            filterChain.doFilter(request, response);
        } catch (FunctionalException ex) {
            log.debug("A functional error occurred: {}", ex.getMessage());
            httpResponse.setStatus(500);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write(ex.getMessage());
        }
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return Arrays.asList(SecurityConfig.WHITE_LIST_URI).stream().anyMatch(url -> new AntPathRequestMatcher(url).matches(request));
    }
}
