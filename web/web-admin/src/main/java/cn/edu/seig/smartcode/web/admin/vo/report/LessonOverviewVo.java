package cn.edu.seig.smartcode.web.admin.vo.report;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: LessonOverviewVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.report
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/21 1:02
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "课程总览")
@Builder
public class LessonOverviewVo {
    @Schema(description = "已上架课程数量")
    private Long alreadyListedCount;

    @Schema(description = "未上架课程数量")
    private Long notListCount;

    @Schema(description = "全部课程数量")
    private Long allLessonCount;


}
