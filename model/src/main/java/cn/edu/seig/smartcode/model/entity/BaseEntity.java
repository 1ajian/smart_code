package cn.edu.seig.smartcode.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: BaseEntity
 * Package: cn.edu.seig.smartcode.model.entity
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 20:56
 * @Version 1.0
 */
@Data
public class BaseEntity implements Serializable {
    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
//    @JsonIgnore
    private Date createTime;

    @Schema(description = "更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
//    @JsonIgnore
    private Date updateTime;

    @TableLogic
    @Schema(description = "逻辑删除")
    @TableField("is_deleted")
    @JsonIgnore
    private Byte isDeleted;
}
