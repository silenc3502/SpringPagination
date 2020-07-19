package proj.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class AuthUtil {
    public static long getUserNo(String header) throws Exception {
        String token = header.substring(7);

        byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

        Jws<Claims> parsedToken = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token);

        String subject = parsedToken.getBody().getSubject();

        long userNo = Integer.parseInt(subject);

        return userNo;
    }

}