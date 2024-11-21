package cn.edu.seig.smartcode.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 资料类型表 例如软考
 * @TableName resource_type
 */
@TableName(value ="resource_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "资源类型类")
public class ResourceType extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 资料类型名称
     */
    private String typeName;

    /**
     * 上传管理员ID
     */
    private Long uploadAdminId;


}