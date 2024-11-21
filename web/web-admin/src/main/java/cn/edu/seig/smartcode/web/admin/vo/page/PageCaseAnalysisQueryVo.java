package cn.edu.seig.smartcode.web.admin.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: PageCaseAnalysisQueryVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 18:48
 * @Version 1.0
 */
@Data
@Slf4j
@Schema(description = "案例分析分页查询条件")
@NoArgsConstructor
@AllArgsConstructor
public class PageCaseAnalysisQueryVo extends PageQueryVo {
    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @Schema(description = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
