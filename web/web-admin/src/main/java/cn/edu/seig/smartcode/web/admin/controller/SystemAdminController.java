package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.constant.AdminPasswordConstant;
import cn.edu.seig.smartcode.common.exception.SmartCodeException;
import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.common.result.ResultCodeEnum;
import cn.edu.seig.smartcode.model.entity.SystemUser;
import cn.edu.seig.smartcode.model.enums.BaseEnum;
import cn.edu.seig.smartcode.model.enums.BaseStatus;
import cn.edu.seig.smartcode.web.admin.service.SystemUserService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.SystemUserPageQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: SystemAdminController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 21:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/systemAdmin")
@Tag(name = "系统用户管理")
@CrossOrigin
public class SystemAdminController {

    @Autowired
    private SystemUserService systemUserService;

    @PostMapping("/saveOrUpdate")
    @Operation(summary = "新增或者修改系统用户")
    public Result saveOrUpdateAdmin(@RequestBody SystemUser systemUser) {
        if (systemUser.getId() == null && StringUtils.isBlank(systemUser.getPassword())) {
            String md5Pwd = DigestUtils.md5Hex(AdminPasswordConstant.DEFAULT_PASSWORD);
            systemUser.setPassword(md5Pwd);
        }else {
            String md5Pwd = DigestUtils.md5Hex(systemUser.getPassword());
            systemUser.setPassword(md5Pwd);
        }
        systemUserService.saveOrUpdate(systemUser);
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除管理员用户")
    public Result removeAdmin(@PathVariable Long id) {
        if (id == null) {
            throw new SmartCodeException(ResultCodeEnum.PARAM_ERROR);
        }
        SystemUser systemUser = systemUserService.getById(id);
        if ("root".equals(systemUser.getUsername())) {
            throw new SmartCodeException(601,"root管理员用户无法被删除");
        }

        systemUserService.removeById(id);

        return Result.ok();
    }

    @GetMapping("/page")
    @Operation(summary = "分页查询系统用户信息")
    public Result<PageResultVo> page(SystemUserPageQueryVo systemUserPageQueryVo) {
        PageResultVo pageResultVo = systemUserService.pageInfo(systemUserPageQueryVo);
        return Result.ok(pageResultVo);
    }

    @PutMapping("/updateStatus")
    @Operation(summary = "更新用户状态")
    public Result updateStatus(Long id, BaseStatus status) {
        LambdaUpdateWrapper<SystemUser> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(status != null,SystemUser::getStatus,status).eq(SystemUser::getId, id);
        systemUserService.update(wrapper);
        return Result.ok();
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据管理员id获取信息")
    public Result<SystemUser> getByAdminId(@PathVariable Long id) {
        SystemUser user = systemUserService.getById(id);
        user.setPassword("******");
        return Result.ok(user);
    }

    @GetMapping
    @Operation(summary = "查询全部管理员信息")
    public Result<List<SystemUser>> list() {
        List<SystemUser> list = systemUserService.list();
        list.forEach(systemUser -> {
            systemUser.setPassword("******");
        });
        return Result.ok(list);
    }

    @GetMapping("/getAdminByname")
    @Operation(summary = "通过管理员用户名获取管理信息")
    public Result<SystemUser> getAdminByname(String username) {
        LambdaQueryWrapper<SystemUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(username),SystemUser::getUsername,username);
        SystemUser user = systemUserService.getOne(wrapper);
        user.setPassword("******");
        return Result.ok(user);
    }

    @PostMapping("/logout")
    @Operation(summary = "退出登录")
    public Result logout() {
        return Result.ok();
    }

}
