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
 * 点赞详情表
 * @TableName like_detail
 */
@TableName(value ="like_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDetail extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 点赞用户Id
     */
    private Long userId;

    /**
     * 点赞时间
     */
    private Date likeTime;

    /**
     * 点赞类型Id
     */
    private Long likeTypeId;

    /**
     * 点赞详细内容id
     */
    private Long likeContentId;


}