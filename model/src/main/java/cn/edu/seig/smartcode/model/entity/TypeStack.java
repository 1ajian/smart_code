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
 * 课程和技术栈联系表
 * @TableName type_stack
 */
@TableName(value ="type_stack")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeStack extends BaseEntity{

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 技术栈Id
     */
    private Long technologyStackId;

    /**
     * 课程类型Id
     */
    private Long lessonTypeId;

}