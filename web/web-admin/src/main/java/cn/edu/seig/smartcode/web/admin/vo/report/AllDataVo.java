package cn.edu.seig.smartcode.web.admin.vo.report;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: AllDataVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.report
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/21 0:47
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "报告总数数据")
@Builder
public class AllDataVo {

    @Schema(description = "课程总数")
    private Long lessonCount;

    @Schema(description = "资源总数")
    private Long resourceCount;

    @Schema(description = "学习路线总数")
    private Long wayCount;

    @Schema(description = "案例分析总数")
    private Long caseAnalysisCount;
}
