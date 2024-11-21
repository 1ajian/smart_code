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
 * 点赞类型表
 * @TableName like_type
 */
@TableName(value ="like_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeType extends BaseEntity{

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 点赞分类名称
     */
    private String name;

}