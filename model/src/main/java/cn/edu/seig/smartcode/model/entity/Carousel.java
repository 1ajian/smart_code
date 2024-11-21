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
 * 轮播图表
 * @TableName carousel
 */
@TableName(value ="carousel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carousel extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 图片url
     */
    private String imageUrl;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 微信公众号链接
     */
    private String wechatLink;

    /**
     * 创建人Id
     */
    private Long createAdminId;

}