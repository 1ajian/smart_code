package cn.edu.seig.smartcode.web.admin.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: PageCommunicationQueryVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 15:57
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "社区交流分页查询Vo")
public class PageCommunicationQueryVo extends PageQueryVo{
    @Schema(description = "社区交流类型")
    private Long communicationTypeId;

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "文章内容")
    private String content;

    @Schema(description = "文章标题")
    private String title;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @Schema(description = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
