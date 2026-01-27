package fr.lostaria.hytaleauthservice.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    String secretKey;

    public String generateToken(String deviceToken) {
        String deviceId = deviceToken.split(":")[0];
        Instant now = Instant.now();

        return JWT.create()
                .withIssuer("auth-service")
                .withSubject(deviceId)
                .withExpiresAt(Date.from(now.plusSeconds(3600)))
                .sign(Algorithm.HMAC256(secretKey));
    }

}
