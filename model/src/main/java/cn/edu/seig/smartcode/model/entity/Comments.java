package cn.edu.seig.smartcode.model.entity;

import cn.edu.seig.smartcode.model.enums.CommentArticleType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评论表
 * @TableName comments
 */
@TableName(value ="comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 评论的文章类型 0是交流表类型 1是案例分析类型
     */
    private CommentArticleType articleType;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论用户Id
     */
    private Long commentUserId;

    /**
     * 顶级评论id 若是第一条 评论则为null
     */
    private Long topLevelId;

    /**
     * 回复评论目标Id
     */
    private Long replyTargetId;

    /**
     * 点赞数
     */
    private Long likeCount;

    /**
     * 文章Id
     */
    private Long communicationId;


}