package cn.edu.seig.smartcode.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学习路线与技术栈的中间表
 * @TableName way_stack
 */
@TableName(value ="way_stack")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WayStack extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 路线id
     */
    private Long wayId;

    /**
     * 技术栈id
     */
    private Long stackId;

    /**
     * 上传管理员id
     */
    private Long uploadAdminId;


}