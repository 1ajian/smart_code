package cn.edu.seig.smartcode.model.entity;

import cn.edu.seig.smartcode.model.enums.BaseStatus;
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
 * 用户信息表
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends BaseEntity {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 角色 0学生 1教师 2企业人员
     */
    private Integer role;

    /**
     * 微信OpenID
     */
    private String openid;

    /**
     * 头像URL
     */
    private String avatarUrl;

    /**
     * 性别 1男 0女
     */
    private Integer gender;

    /**
     * 状态 1启用 2禁用
     */
    private BaseStatus status;

    /**
     * 技术栈Id(学习路线)
     */
    private Long wayId;


}