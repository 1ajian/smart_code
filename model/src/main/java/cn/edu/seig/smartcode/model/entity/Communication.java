package cn.edu.seig.smartcode.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 社区交流表
 * @TableName communication
 */
@TableName(value ="communication")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Communication extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 评论条数
     */
    private Long commentsCount;

    /**
     * 点赞数量
     */
    private Long likeNumber;

    /**
     * 收藏数
     */
    private Long collectCount;

    /**
     * 分享次数
     */
    private Long shareCount;

    /**
     * 所属用户Id
     */
    private Long userId;

    /**
     * 社区交流类型Id
     */
    private Long communicationTypeId;

}