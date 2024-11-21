package cn.edu.seig.smartcode.web.admin.vo.page;

import cn.edu.seig.smartcode.model.entity.LessonType;
import cn.edu.seig.smartcode.model.entity.TechnologyStack;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ClassName: PageLesAndTecVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/19 17:57
 * @Version 1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(description = "分页查询课程类型和技术栈返回Vo")
public class PageLesAndTecVo extends LessonType {


    @Schema(description = "技术栈集合")
    private List<TechnologyStack> technologyStacks;
}
