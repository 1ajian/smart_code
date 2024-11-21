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
 * 课程类型和具体课程之间的联系
 * @TableName type_detail_lesson
 */
@TableName(value ="type_detail_lesson")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDetailLesson extends BaseEntity{
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 课程Id
     */
    private Long lessonId;

    /**
     * 课程类型Id
     */
    private Long lessonTypeId;

}