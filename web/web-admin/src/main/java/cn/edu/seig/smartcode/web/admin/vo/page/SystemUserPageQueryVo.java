package cn.edu.seig.smartcode.web.admin.vo.page;

import cn.edu.seig.smartcode.model.enums.BaseStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: SystemUserPageQueryVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.system.user
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 21:50
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户分页查询Vo")
public class SystemUserPageQueryVo extends PageQueryVo {
    private String username;

    private BaseStatus status;

    private String phone;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
