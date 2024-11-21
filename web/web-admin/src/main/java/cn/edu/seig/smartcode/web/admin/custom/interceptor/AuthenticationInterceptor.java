package cn.edu.seig.smartcode.web.admin.custom.interceptor;

import cn.edu.seig.smartcode.common.login.LoginUser;
import cn.edu.seig.smartcode.common.login.LoginUserHolder;
import cn.edu.seig.smartcode.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: AuthenticationInterceptor
 * Package: cn.edu.seig.smartcode.web.admin.custom.interceptor
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 22:51
 * @Version 1.0
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        Claims claims = JwtUtil.parseToken(token);
        Long userId = claims.get("userId", Long.class);
        String username = claims.get("username", String.class);
        LoginUser loginUser = new LoginUser(userId, username);
        LoginUserHolder.setLoginUser(loginUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserHolder.clear();
    }
}
