package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.SystemUser;
import cn.edu.seig.smartcode.web.admin.vo.page.SystemUserPageQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;

/**
* @author 86135
* @description 针对表【system_user(管理员信息表)】的数据库操作Mapper
* @createDate 2024-11-16 20:40:27
* @Entity cn.edu.seig.smartcode.model.entity.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    /**
     * 根据用户名查询管理员信息
     * @param username
     * @return
     */
    SystemUser selectByUsername(String username);

    /**
     * 分页和条件查询系统用户信息
     * @param page
     * @param userQueryVo
     * @return
     */
    IPage<SystemUser> page(Page<SystemUser> page, SystemUserPageQueryVo userQueryVo);
}




