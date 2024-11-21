package cn.edu.seig.smartcode.web.admin.vo.system.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * ClassName: SystemUserInfoVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.system.user
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 10:42
 * @Version 1.0
 */
@Schema(description = "员工基本信息")
@Data
public class SystemUserInfoVo {

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "用户头像")
    private String avatarUrl;
}
