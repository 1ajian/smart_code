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
 * 管理员信息表
 * @TableName system_user
 */
@TableName(value ="system_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

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
     * 手机号
     */
    private String phone;

    /**
     * 创建人Id
     */
    private Long createAdminId;


}