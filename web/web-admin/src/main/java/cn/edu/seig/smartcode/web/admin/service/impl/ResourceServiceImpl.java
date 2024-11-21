package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.model.entity.Resource;
import cn.edu.seig.smartcode.web.admin.mapper.ResourceMapper;
import cn.edu.seig.smartcode.web.admin.service.ResourceService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourcePageQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86135
* @description 针对表【resource(资料信息表 ,具体资料 比如软件设计师24和25年真题)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:26
*/
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource>
    implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageResultVo getPage(ResourcePageQueryVo pageQueryVo) {
        Page<Resource> page = new Page<>(pageQueryVo.getPage(), pageQueryVo.getPageSize());
        IPage<Resource> result = resourceMapper.page(page,pageQueryVo);
        return new PageResultVo(result.getTotal(),result.getRecords());
    }
}




