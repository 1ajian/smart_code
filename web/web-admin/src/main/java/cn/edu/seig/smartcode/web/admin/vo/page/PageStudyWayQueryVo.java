package cn.edu.seig.smartcode.web.admin.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: PageStudyWayQueryVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 20:32
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "学习路线分页查询条件")
public class PageStudyWayQueryVo extends PageQueryVo {

    @Schema(description = "学习路线名称")
    private String name;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @Schema(description = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
