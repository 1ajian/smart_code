package cn.edu.seig.smartcode.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 具体课程表 例如具体 React18 等课程
 * @TableName lesson
 */
@TableName(value ="lesson")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson extends BaseEntity{
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 课程链接
     */
    private String url;

    /**
     * 课程描述
     */
    private String desciption;

    /**
     * 总时长
     */
    private String totalDuration;

    /**
     * 收藏数
     */
    private Long collectNum;

    /**
     * 点赞数
     */
    private Long likeNum;

    /**
     * 资源ID
     */
    private Long resourceId;

    /**
     * 上传管理员ID
     */
    private Long uploadAdminId;

    /**
     * 技术栈ID
     */
    private Long technologyStackId;

    /**
     * 课程排序
     */
    private Integer orders;


}