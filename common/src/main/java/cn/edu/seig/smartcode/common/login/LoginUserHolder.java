package cn.edu.seig.smartcode.common.login;

/**
 * ClassName: LoginUserHolder
 * Package: cn.edu.seig.smartcode.common.login
 * Description:
 *      线程变量类
 * @Author 阿小健
 * @Create 2024/11/16 14:27
 * @Version 1.0
 */
public class LoginUserHolder {
    public static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();

    public static void setLoginUser(LoginUser loginUser) {
        threadLocal.set(loginUser);
    }

    public static LoginUser getLoginUser() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
