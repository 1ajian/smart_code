package cn.edu.seig.smartcode.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学习路线表
 * @TableName study_way
 */
@TableName(value ="study_way")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyWay extends BaseEntity {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    /**
     * 学习路线名称 例如java后端，java大数据
     */
    private String name;

    /**
     * 上传管理员id
     */
    private Long uploadAdminId;

    @Schema(description = "用户名")
    @TableField(exist = false)
    private String username;

}