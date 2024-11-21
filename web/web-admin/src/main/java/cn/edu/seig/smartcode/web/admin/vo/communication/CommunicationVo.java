package cn.edu.seig.smartcode.web.admin.vo.communication;

import cn.edu.seig.smartcode.model.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.runtime.Desc;

import java.util.Date;

/**
 * ClassName: CommunicationVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.communication
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 16:28
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "社区交流返回结果Vo")
public class CommunicationVo  {
    @Schema(description = "主键Id")
    private Long id;

    @Schema(description = "发布者Id")
    private Long userId;

    @Schema(description = "用户昵称")
    private String nickname;

    @Schema(description = "类型名称")
    private String typename;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "评论数量")
    private Long commentsCount;

    @Schema(description = "点赞数量")
    private Long likeNumber;

    @Schema(description = "收藏数量")
    private Long collectCount;

    @Schema(description = "分享数量")
    private Long shareCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private Date createTime;

    @JsonIgnore
    @Schema(description = "更新时间")
    private Date updateTime;

    @JsonIgnore
    @Schema(description = "逻辑删除")
    private Integer isDeleted;

}
