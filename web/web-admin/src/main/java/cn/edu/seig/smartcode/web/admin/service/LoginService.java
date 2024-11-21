package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.web.admin.vo.login.CaptchaVo;
import cn.edu.seig.smartcode.web.admin.vo.login.LoginVo;
import cn.edu.seig.smartcode.web.admin.vo.system.user.SystemUserInfoVo;

/**
 * ClassName: LoginService
 * Package: cn.edu.seig.smartcode.web.admin.service
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 9:23
 * @Version 1.0
 */
public interface LoginService {
    /**
     * 获取验证码
     * @return
     */
    CaptchaVo getCaptcha();

    /**
     * 登录
     * @param loginVo
     * @return
     */
    String login(LoginVo loginVo);

    /**
     * 根据Id获取管理员信息
     * @param adminId
     * @return
     */
    SystemUserInfoVo getInfoById(Long adminId);
}
