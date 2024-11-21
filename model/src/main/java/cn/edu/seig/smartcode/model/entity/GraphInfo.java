package cn.edu.seig.smartcode.model.entity;

import cn.edu.seig.smartcode.model.enums.ItemType;
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
 * 图片表
 * @TableName graph_info
 */
@TableName(value ="graph_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphInfo extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 图片类型 1是课程图片  2是交流表相关图片 3案例分析图片  4资料图片
     */
    private ItemType itemType;

    /**
     * 图片所属内容Id
     */
    private Long itemId;

    /**
     * 图片链接
     */
    private String url;

}