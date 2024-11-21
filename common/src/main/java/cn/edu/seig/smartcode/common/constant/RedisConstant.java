package cn.edu.seig.smartcode.common.constant;

/**
 * ClassName: RedisConstant
 * Package: cn.edu.seig.smartcode.common.constant
 * Description:
 * redis登录相关常量类
 * @Author 阿小健
 * @Create 2024/11/16 13:55
 * @Version 1.0
 */
public class RedisConstant {
    public static final String ADMIN_LOGIN_PREFIX = "admin:login:";

    public static final Integer ADMIN_LOGIN_CAPTCHA_TTL_SEC = 60;

    public static final String WX_LOGIN_PREFIX = "wx:login:";

    public static final Integer WX_LOGIN_CODE_RESEND_TIME_SEC = 60;

    public static final Integer WX_LOGIN_CODE_TTL_SEC = 60 * 5;


}
