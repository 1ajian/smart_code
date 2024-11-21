package cn.edu.seig.smartcode.common.utils;

import cn.edu.seig.smartcode.common.constant.JwtClaimsConstant;
import cn.edu.seig.smartcode.common.exception.SmartCodeException;
import cn.edu.seig.smartcode.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * ClassName: JwtUtil
 * Package: cn.edu.seig.smartcode.common.utils
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 14:58
 * @Version 1.0
 */
public class JwtUtil {
    private static SecretKey key = Keys.hmacShaKeyFor("cneduseigguangzhouruanjiansmartc".getBytes());

    public static String createToken(Long userId,String username) {
        String jwt = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + 3600000 * 24 * 365))
                .setSubject("LOGIN_USER")
                .claim(JwtClaimsConstant.USER_ID, userId)
                .claim(JwtClaimsConstant.USER_NAME, username)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return jwt;
    }

    public static Claims parseToken(String token) {
        if (token == null || "".equals(token)) {
            throw new SmartCodeException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }

        try {
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
            return claimsJws.getBody();
        }catch(ExpiredJwtException e) {
            throw new SmartCodeException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch (JwtException e) {
            throw new SmartCodeException(ResultCodeEnum.TOKEN_INVALID);
        }
    }

    public static void main(String[] args) {
        System.out.println(parseToken(createToken(1L, "13888888888")));

    }
}
