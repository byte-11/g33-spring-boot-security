package uz.pdp.g33springbootsecurity.config.jtw;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uz.pdp.g33springbootsecurity.User;

@Component
public class JwtProvider {

    @Value("${jjwt.token.expiration-sec}")
    private Long expirationTime;

    @Value("${jjwt.token.secret}")
    private String secretKey;

    public String generate(final User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime * 1000))
                .claim("roles", user.getRoles())
                .signWith(key())
                .compact();
    }

    public SecretKey key(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public Claims parse(final String token) {
        return Jwts.parser()
                .decryptWith(key())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validate(final String token) {
        try {
            Claims claims = parse(token);
            if(claims.getExpiration().after(new Date())) {
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            return  false;
        }

        return false;
    }

}
