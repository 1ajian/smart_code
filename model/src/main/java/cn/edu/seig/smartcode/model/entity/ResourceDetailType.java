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
 * 资料具体类型表 例如软考的软件设计师
 * @TableName resource_detail_type
 */
@TableName(value ="resource_detail_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDetailType extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 资料类型Id
     */
    private Long resourceTypeId;

    /**
     * 资料具体类型名称
     */
    private String resourceName;

    /**
     * 上传管理员ID
     */
    private Long uploadAdminId;


}