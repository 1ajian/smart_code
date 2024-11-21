package cn.edu.seig.smartcode.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName: CaptchaVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.login
 * Description:
 *      验证码返回对象
 * @Author 阿小健
 * @Create 2024/11/17 9:13
 * @Version 1.0
 */
@Data
@Schema(description = "图像验证码")
@AllArgsConstructor
public class CaptchaVo {

    @Schema(description = "验证码图片信息")
    private String image;

    @Schema(description = "验证码key")
    private String key;
}
