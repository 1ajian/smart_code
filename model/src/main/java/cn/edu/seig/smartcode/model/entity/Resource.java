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
 * 资料信息表 ,具体资料 比如软件设计师24和25年真题
 * @TableName resource
 */
@TableName(value ="resource")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 资料名称
     */
    private String name;

    /**
     * 资料链接
     */
    private String url;

    /**
     * 上传管理员ID
     */
    private Long uploadAdminId;

    /**
     * 下载次数
     */
    private Long downloadCount;

    /**
     * 阅读次数
     */
    private Long readCount;

    /**
     * 资料类型Id
     */
    private Long resourceTypeId;

    /**
     * 资料具体类型Id
     */
    private Long resourceDetailType;


}