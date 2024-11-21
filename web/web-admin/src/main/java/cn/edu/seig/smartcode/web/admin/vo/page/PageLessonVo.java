package cn.edu.seig.smartcode.web.admin.vo.page;

import cn.edu.seig.smartcode.model.entity.GraphInfo;
import cn.edu.seig.smartcode.model.entity.Lesson;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageLessonVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 11:08
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "课程分页查询结果")
public class PageLessonVo extends Lesson {
    @Schema(description = "封面图片url")
    private List<GraphInfo> faceUrl;

    @Schema(description = "资源链接")
    private String resourceUrl;
}
