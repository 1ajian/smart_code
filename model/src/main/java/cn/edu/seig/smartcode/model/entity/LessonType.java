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
 * 课程类型表
 * @TableName lesson_type
 */
@TableName(value ="lesson_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonType extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 课程类型名称 比如前端、后端
     */
    private String typeName;

    /**
     * 创建人Id
     */
    private Long createAdminId;


}