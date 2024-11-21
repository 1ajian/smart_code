package cn.edu.seig.smartcode.common.login;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName: LoginUser
 * Package: cn.edu.seig.smartcode.common.login
 * Description:
 *      登录用户为线程变量而准备
 * @Author 阿小健
 * @Create 2024/11/16 14:26
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class LoginUser {
    private Long userId;
    private String username;
}
