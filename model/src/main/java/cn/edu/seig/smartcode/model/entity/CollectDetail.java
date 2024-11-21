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
 * 收藏详细内容表
 * @TableName collect_detail
 */
@TableName(value ="collect_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectDetail extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 收藏时间
     */
    private Date collectTime;

    /**
     * 收藏内容Id
     */
    private Long contentId;

    /**
     * 收藏类型Id
     */
    private Long collectTypeId;



}