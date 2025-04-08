package com.frenos_el_control.principal.auth.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret_key}")
    private String SECRET_KEY;
    @Value("${jwt.expiration}")
    private Long jwtExpiration;
    @Value("${jwt.refresh-token.expiration}")
    private Long refreshTokenExpiration;

    public String getToken(UserDetails user)
    {
        return getToken(new HashMap<>(),user);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails user){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpiration))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    // Apartado de Refresh:
    public String getRefreshToken(UserDetails user) {
        return generateToken(new HashMap<>(), user, refreshTokenExpiration);
    }
    private String generateToken(Map<String, Object> extraClaims, UserDetails user, Long expiration) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isRefreshTokenValid(String token, UserDetails userDetails) {
        final String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && isTokenExpired(token);
    }

    // ------------------------------ Resto del refresh
    private Key getKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Apartado de Autenticación:

    public boolean isTokenValid(String token, UserDetails userDetails)
    {
        final String username= getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername())&& isTokenExpired(token));
    }

    public String getUserNameFromToken(String token){
        return getClaim(token, Claims::getSubject).orElse(null);
    }
    public Claims getAllClaims(String token) throws Exception {
        if (StringUtils.isEmpty(token))
        {
            throw new Exception("No se puede encontrar el token");
        }
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //Apartado de obtener fecha de expiración
    private Date getExpiration(String token){
        return getClaim(token,Claims::getExpiration).orElse(null);
    }
    private boolean isTokenExpired(String token){
        return !getExpiration(token).before(new Date());
    }
    // Una función genérica para obtener cualquier tipo de claim
    public <T> Optional<T> getClaim(String token, Function<Claims,T> claimResolver)
    {
        try {
            final Claims claims = getAllClaims(token);

            return Optional.of(claimResolver.apply(claims));
        }catch (Exception e){
            return Optional.empty();
        }
    }

}
