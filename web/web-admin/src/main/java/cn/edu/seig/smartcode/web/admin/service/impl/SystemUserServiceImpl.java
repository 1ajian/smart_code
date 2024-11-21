package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.SystemUser;
import cn.edu.seig.smartcode.web.admin.mapper.SystemUserMapper;
import cn.edu.seig.smartcode.web.admin.service.SystemUserService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.SystemUserPageQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86135
* @description 针对表【system_user(管理员信息表)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:27
*/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
    implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;
    @Override
    public PageResultVo pageInfo(SystemUserPageQueryVo systemUserPageQueryVo) {
        Page<SystemUser> page = new Page<>(systemUserPageQueryVo.getPage(),systemUserPageQueryVo.getPageSize());
        IPage<SystemUser> result = systemUserMapper.page(page,systemUserPageQueryVo);
        List<SystemUser> records = result.getRecords();
        long total = result.getTotal();
        return new PageResultVo(total,records);
    }
}




