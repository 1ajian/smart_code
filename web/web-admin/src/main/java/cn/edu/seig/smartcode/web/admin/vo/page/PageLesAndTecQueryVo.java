package cn.edu.seig.smartcode.web.admin.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: PageLesAndTecQueryVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/19 17:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "分页查询课程类型和技术栈Vo")
public class PageLesAndTecQueryVo extends PageQueryVo{
    @Schema(description = "课程类型名称")
    private String typeName;

    @Schema(description = "技术栈名称")
    private String technologyName;

}
