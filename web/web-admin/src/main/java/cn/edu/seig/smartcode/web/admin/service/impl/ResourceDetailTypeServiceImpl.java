package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.common.exception.SmartCodeException;
import cn.edu.seig.smartcode.common.result.ResultCodeEnum;
import cn.edu.seig.smartcode.model.entity.Resource;
import cn.edu.seig.smartcode.model.entity.ResourceDetailType;
import cn.edu.seig.smartcode.web.admin.mapper.ResourceDetailTypeMapper;
import cn.edu.seig.smartcode.web.admin.service.ResourceDetailTypeService;
import cn.edu.seig.smartcode.web.admin.service.ResourceService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86135
* @description 针对表【resource_detail_type(资料具体类型表 例如软考的软件设计师)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:27
*/
@Service
public class ResourceDetailTypeServiceImpl extends ServiceImpl<ResourceDetailTypeMapper, ResourceDetailType>
    implements ResourceDetailTypeService {

    @Autowired
    private ResourceService resourceService;

    @Override
    public void deleteById(Long id) {
        LambdaQueryWrapper<Resource> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Resource::getResourceDetailType, id);
        long count = resourceService.count(wrapper);
        if (count > 0) {
            throw new SmartCodeException(ResultCodeEnum.DELETE_ERROR);
        }
        removeById(id);
    }
}




