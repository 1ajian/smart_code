package cn.edu.seig.smartcode.web.admin.vo.page;

import cn.edu.seig.smartcode.model.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: UserPageQueryVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/19 16:02
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户分页查询")
public class UserPageQueryVo extends PageQueryVo{

    @Schema(description = "手机号码")
    private String phone;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "用户状态")
    private BaseStatus status;

    @Schema(description = "起始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @Schema(description = "终止时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
