package com.evn.utilitypolemanagement.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Value("${security.jwt.secret-key}")
    private String secretKey;


    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Extract information from claims and set it in the SecurityContext
            String username = claims.getSubject();
            String aud = claims.getAudience();
            if(aud.equals("SPC.HTVTCNTT")){
                List<String> roles = claims.get("roles", List.class);

                // Convert roles to SimpleGrantedAuthority list
                List<SimpleGrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                if (username != null) {
                    // Create an Authentication object
                    var authentication = new UsernamePasswordAuthenticationToken(
                            username,
                            username,
                            authorities // You can set authorities here
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }else{
                SecurityContextHolder.clearContext();
            }

        } catch (Exception e) {
            // If token is invalid or expired
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = secretKey.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
