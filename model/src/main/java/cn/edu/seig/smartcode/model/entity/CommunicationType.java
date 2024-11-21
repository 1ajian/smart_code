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
 * 社区交流类型表
 * @TableName communication_type
 */
@TableName(value ="communication_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationType extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 交流分类名称
     */
    private String name;

    /**
     * 上传用户Id
     */
    private Long uploadAdminId;


}