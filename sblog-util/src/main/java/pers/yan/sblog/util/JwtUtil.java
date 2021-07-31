package pers.yan.sblog.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Date;

/**
 * jwt功能
 *
 * @author likaiyan
 * @date 2021/7/26 1:43 下午
 */
@Component
@Slf4j
public class JwtUtil {

    private static String secret;

    private static long expiration;

    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        JwtUtil.secret = secret;
    }

    @Value("${jwt.expiration:3600}")
    public void setExpiration(long expiration) {
        JwtUtil.expiration = expiration;
    }

    public static String generateToken(String id) {
        return Jwts.builder()
                .setSubject(id)
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public static String refreshToken(String oldToken) {
        if (StringUtils.hasText(oldToken) && validateToken(oldToken)) {
            return generateToken(getUserIdFromToken(oldToken));
        }
        return null;
    }

    public static boolean validateToken(String token) {
        try {
            return !isTokenExpired((token));
        } catch (ExpiredJwtException ex) {
            log.error("校验token失败", ex);
        }
        return false;
    }

    public static boolean isTokenExpired(String token) {
        return new Date().after(getExpirationDateFromToken(token));
    }

    public static Date getExpirationDate() {
        return Date.from(Instant.now().plusMillis(1000 * expiration));
    }

    public static Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public static Date getExpirationDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    public static String getUserIdFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject();
    }

}
