package cn.edu.seig.smartcode.web.admin.vo.page;

import cn.edu.seig.smartcode.model.entity.Lesson;
import cn.edu.seig.smartcode.model.entity.TechnologyStack;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ClassName: PageWayLessonVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 21:32
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@Schema(description = "分页查询学习路线技术栈课程返回结果Vo")
public class PageWayLessonVo extends TechnologyStack {

}
