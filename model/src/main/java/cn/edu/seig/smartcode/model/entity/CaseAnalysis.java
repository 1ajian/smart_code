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
 * 案例分析表
 * @TableName case_analysis
 */
@TableName(value ="case_analysis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseAnalysis extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 案例内容
     */
    private String content;

    /**
     * 相关具体资源链接
     */
    private String caseUrl;

}