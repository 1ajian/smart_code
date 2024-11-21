package cn.edu.seig.smartcode.web.admin.vo.report;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.runtime.Desc;

/**
 * ClassName: UserOverview
 * Package: cn.edu.seig.smartcode.web.admin.vo.report
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/21 1:16
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "用户总览")
@Builder
public class UserOverview {
    @Schema(description = "今日新增")
    private Long todayCount;

    @Schema(description = "昨天新增")
    private Long yesterdayCount;

    @Schema(description = "本月新增")
    private Long thisMonthCount;

    @Schema(description = "用户总量")
    private Long allCount;
}
