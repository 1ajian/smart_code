package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.login.LoginUserHolder;
import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.web.admin.service.LoginService;
import cn.edu.seig.smartcode.web.admin.vo.login.CaptchaVo;
import cn.edu.seig.smartcode.web.admin.vo.login.LoginVo;
import cn.edu.seig.smartcode.web.admin.vo.system.user.SystemUserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: LoginController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 9:20
 * @Version 1.0
 */
@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login/captcha")
    @Operation(summary = "获取图形验证码")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo result = loginService.getCaptcha();
        return Result.ok(result);
    }

    @PostMapping("/login")
    @Operation(summary = "登录")
    public Result<String> loginVo(@RequestBody LoginVo loginVo) {
        String token = loginService.login(loginVo);
        return Result.ok(token);
    }

    @Operation(summary = "获取登录用户个人信息")
    @GetMapping("/info")
    public Result<SystemUserInfoVo> info() {
        Long adminId = LoginUserHolder.getLoginUser().getUserId();
        SystemUserInfoVo systemUserInfoVo = loginService.getInfoById(adminId);
        return Result.ok(systemUserInfoVo);
    }

}
