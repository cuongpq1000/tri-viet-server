package com.example.triviet.service.impl;

import com.example.triviet.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {
  @Value("${jwt.secret_key}")
  private String jwtKey;

  @Value("${jwt.expiration}")
  private String expireDuration;

  /**
   * generate a signing key for jwt
   *
   * @return a HMAC-SHA key using the decoded byte array
   */
  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(jwtKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  /**
   * extracts the claim from jwt
   *
   * @param token the jwt token
   * @return the user email
   */
  @Override
  public String getUserEmail(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  @Override
  public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expireDuration)))
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  @Override
  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  @Override
  public boolean isTokenValid(String token, UserDetails userDetails) {
    String userEmail = getUserEmail(token);
    return userEmail.equals(userDetails.getUsername()) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    return extractClaim(token, Claims::getExpiration).before(new Date());
  }

  /**
   * extract a specific claim from a JWT token.
   *
   * @param token jwt token
   * @param claimsResolver the function to extract claim
   * @return the object
   * @param <T> object
   */
  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(getSignInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }
}
