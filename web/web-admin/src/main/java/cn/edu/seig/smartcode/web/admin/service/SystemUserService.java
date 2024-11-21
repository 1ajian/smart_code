package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.SystemUser;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.SystemUserPageQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【system_user(管理员信息表)】的数据库操作Service
* @createDate 2024-11-16 20:35:51
*/
public interface SystemUserService extends IService<SystemUser> {

    /**
     * 分页和条件查询系统用户信息
     * @param systemUserPageQueryVo
     * @return
     */
    PageResultVo pageInfo(SystemUserPageQueryVo systemUserPageQueryVo);
}
