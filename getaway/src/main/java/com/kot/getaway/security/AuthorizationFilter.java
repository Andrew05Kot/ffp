package com.kot.getaway.security;

import java.util.ArrayList;
import io.jsonwebtoken.Jwts;
import org.springframework.core.env.Environment;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class AuthorizationFilter implements WebFilter {
    private final Environment environment;
    private final String headerName;
    private final String headerPrefix;

    public AuthorizationFilter(Environment environment) {
        super();
        this.environment = environment;
        headerName = environment.getProperty("authorization.token.header.name");
        headerPrefix = environment.getProperty("authorization.token.header.prefix");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             WebFilterChain chain) {
        String authorizationHeader = exchange.getRequest().getHeaders().getFirst(headerName);

        if (authorizationHeader == null || !authorizationHeader.startsWith(headerPrefix)) {
            return chain.filter(exchange);
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(exchange.getRequest());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return chain.filter(exchange);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(ServerHttpRequest request) {
        String authorizationHeader = request.getHeaders().getFirst(headerName);

        if (authorizationHeader == null) {
            return null;
        }

        String token = authorizationHeader.replace(headerPrefix, "");

        String userId = Jwts.parser()
                .setSigningKey(environment.getProperty("token.secret"))
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        if (userId == null) {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
    }
}
