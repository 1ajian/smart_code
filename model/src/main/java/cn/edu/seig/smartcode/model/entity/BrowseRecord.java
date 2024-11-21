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
 * 浏览记录表
 * @TableName browse_record
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="browse_record")
public class BrowseRecord extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 浏览类型id
     */
    private Long browseTypeId;

    /**
     * 浏览内容Id
     */
    private Long contentId;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 浏览时间
     */
    private Date browseTime;
}