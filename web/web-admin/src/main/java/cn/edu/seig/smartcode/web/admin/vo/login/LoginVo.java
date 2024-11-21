package cn.edu.seig.smartcode.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName: LoginVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.login
 * Description:
 *      登录接收对象
 * @Author 阿小健
 * @Create 2024/11/17 9:15
 * @Version 1.0
 */
@Data
@Schema(description = "后台系统登录信息")
@AllArgsConstructor
public class LoginVo {

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "验证码key")
    private String captchaKey;

    @Schema(description = "验证码code")
    private String captchaCode;
}
