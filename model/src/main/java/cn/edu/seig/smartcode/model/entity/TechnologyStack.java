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

/**
 * 技术栈表 比如vue或者是react
 * @TableName technology_stack
 */
@TableName(value ="technology_stack")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyStack extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    /**
     * 技术栈名称
     */
    private String technologyName;

    /**
     * 创建人Id
     */
    private Long createAdminId;

    /**
     * 非数据库字段
     */
    @Schema(description = "发布者")
    @TableField(exist = false)
    private String username;

}