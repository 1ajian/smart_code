package cn.edu.seig.smartcode.web.admin.vo.page;

import cn.edu.seig.smartcode.model.enums.CollectionType;
import cn.edu.seig.smartcode.model.enums.LikeType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: PageDetailLessonQueryVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 9:41
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "根据技术栈Id分页查询具体课程信息")
public class PageDetailLessonQueryVo extends PageQueryVo {

    @Schema(description = "技术栈id")
    private Long stackId;

    @Schema(description = "具体课程名称")
    private String name;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @Schema(description = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
