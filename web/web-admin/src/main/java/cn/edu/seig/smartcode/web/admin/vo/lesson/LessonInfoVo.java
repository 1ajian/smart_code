package cn.edu.seig.smartcode.web.admin.vo.lesson;

import cn.edu.seig.smartcode.model.entity.GraphInfo;
import cn.edu.seig.smartcode.model.entity.Lesson;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: LessonInfoVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.lesson
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 11:55
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "修改课程时展示的具体信息")
public class LessonInfoVo extends Lesson {
    @Schema(description = "封面图片url")
    private List<GraphInfo> faceUrl;

    @Schema(description = "资源链接")
    private String resourceUrl;
}
