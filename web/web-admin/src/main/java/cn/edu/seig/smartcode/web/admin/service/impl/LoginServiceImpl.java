package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.common.constant.RedisConstant;
import cn.edu.seig.smartcode.common.exception.SmartCodeException;
import cn.edu.seig.smartcode.common.result.ResultCodeEnum;
import cn.edu.seig.smartcode.common.utils.JwtUtil;
import cn.edu.seig.smartcode.model.entity.SystemUser;
import cn.edu.seig.smartcode.model.enums.BaseStatus;
import cn.edu.seig.smartcode.web.admin.mapper.SystemUserMapper;
import cn.edu.seig.smartcode.web.admin.service.LoginService;
import cn.edu.seig.smartcode.web.admin.vo.login.CaptchaVo;
import cn.edu.seig.smartcode.web.admin.vo.login.LoginVo;
import cn.edu.seig.smartcode.web.admin.vo.system.user.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.jacoco.agent.rt.internal_43f5073.core.internal.flow.IFrame;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Spliterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: LoginServiceImpl
 * Package: cn.edu.seig.smartcode.web.admin.service.impl
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 9:23
 * @Version 1.0
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SystemUserMapper systemUserMapper;
    @Override
    public CaptchaVo getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String code = specCaptcha.text().toLowerCase();
        log.info("图片验证码{}",code);
        String key = RedisConstant.ADMIN_LOGIN_PREFIX + UUID.randomUUID().toString().replace("-", "");
        stringRedisTemplate.opsForValue().set(key,code,RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);
        return new CaptchaVo(specCaptcha.toBase64(),key);
    }

    @Override
    public String login(LoginVo loginVo) {
        log.info("登录功能参数:{}",loginVo);
        if (loginVo.getCaptchaCode() == null || "".equals(loginVo.getCaptchaCode())) {
            throw new SmartCodeException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }

        String key = loginVo.getCaptchaKey();
        String code = stringRedisTemplate.opsForValue().get(key);
        if (code == null) {
            throw new SmartCodeException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }

        if (!(code.equals(loginVo.getCaptchaCode().toLowerCase()))) {
            throw new SmartCodeException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }

        String username = loginVo.getUsername();
        SystemUser systemUser = systemUserMapper.selectByUsername(username);

        if (systemUser == null) {
            throw new SmartCodeException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }

        if ((systemUser.getStatus() == BaseStatus.DISABLE)) {
            throw new SmartCodeException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }

        if (!(systemUser.getPassword().equals(DigestUtils.md5Hex(loginVo.getPassword())))) {
            throw new SmartCodeException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }

        return JwtUtil.createToken(systemUser.getId(), systemUser.getUsername());
    }

    @Override
    public SystemUserInfoVo getInfoById(Long adminId) {
        SystemUser systemUser = systemUserMapper.selectById(adminId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        BeanUtils.copyProperties(systemUser, systemUserInfoVo);
        return systemUserInfoVo;
    }
}
