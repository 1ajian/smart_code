package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.common.utils.SMSUtil;
import cn.edu.seig.smartcode.model.entity.UserInfo;
import cn.edu.seig.smartcode.model.enums.BaseStatus;
import cn.edu.seig.smartcode.web.admin.service.SystemUserService;
import cn.edu.seig.smartcode.web.admin.service.UserInfoService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.UserPageQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: UserController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/19 15:53
 * @Version 1.0
 */
@Slf4j
@CrossOrigin
@RestController
@Tag(name = "小程序端用户管理")
@RequestMapping("/admin/wxuser")
public class UserController {
    @Autowired
    private SMSUtil smsUtil;
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/page")
    @Operation(summary = "分页查询用户数据")
    public Result<PageResultVo> getPage(UserPageQueryVo userPageQueryVo) {
        PageResultVo resultVo = userInfoService.getPage(userPageQueryVo);
        return Result.ok(resultVo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id获取用户信息")
    public Result<UserInfo> getUser(@PathVariable Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return Result.ok(userInfo);
    }

    @PutMapping("/userStatus")
    @Operation(summary = "更新用户状态")
    public Result updateUserStatus(@RequestParam(required = true) Long id,@RequestParam(required = true) BaseStatus status) {
        LambdaUpdateWrapper<UserInfo> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(UserInfo::getId, id).set(UserInfo::getStatus, status);
        userInfoService.update(wrapper);
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户信息")
    public Result removeUser(@PathVariable Long id) {
        userInfoService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "测试发送短信")
    @GetMapping("/message")
    public Result sendMessage(String phone,String code) {
        smsUtil.sendCode(phone, code);
        return Result.ok();
    }

}
