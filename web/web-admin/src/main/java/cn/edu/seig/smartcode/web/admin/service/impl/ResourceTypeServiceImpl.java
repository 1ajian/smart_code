package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.common.exception.SmartCodeException;
import cn.edu.seig.smartcode.common.result.ResultCodeEnum;
import cn.edu.seig.smartcode.model.entity.Resource;
import cn.edu.seig.smartcode.model.entity.ResourceDetailType;
import cn.edu.seig.smartcode.model.entity.ResourceType;
import cn.edu.seig.smartcode.web.admin.mapper.ResourceTypeMapper;
import cn.edu.seig.smartcode.web.admin.service.ResourceDetailTypeService;
import cn.edu.seig.smartcode.web.admin.service.ResourceService;
import cn.edu.seig.smartcode.web.admin.service.ResourceTypeService;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourcePageQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourceTypeVo;
import cn.edu.seig.smartcode.web.admin.vo.resource.ResourcesTypeVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jacoco.agent.rt.internal_43f5073.core.internal.flow.IFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceEditor;
import org.springframework.stereotype.Service;

/**
* @author 86135
* @description 针对表【resource_type(资料类型表 例如软考)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:27
*/
@Service
@Slf4j
public class ResourceTypeServiceImpl extends ServiceImpl<ResourceTypeMapper, ResourceType>
    implements ResourceTypeService {

    @Autowired
    private ResourceDetailTypeService detailTypeService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceTypeMapper resourceTypeMapper;
    @Override
    public void deleteById(Long id) {
        log.info("id:{}",id);
        LambdaQueryWrapper<ResourceDetailType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ResourceDetailType::getResourceTypeId, id);
        long countDt = detailTypeService.count(wrapper);

        LambdaQueryWrapper<Resource> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Resource::getResourceTypeId,id);
        long countRes = resourceService.count(queryWrapper);
        if ((countRes == 0) && (countDt == 0)) {
            removeById(id);
            return;
        }
        throw new SmartCodeException(ResultCodeEnum.DELETE_ERROR);

    }

    @Override
    public IPage<ResourcesTypeVo> getTypePage(ResourceTypeVo queryVo) {
        log.info("ResourceTypeVo:{}",queryVo);
        if (queryVo != null) {
            IPage<ResourcesTypeVo> page = new Page<>(queryVo.getPage(), queryVo.getPageSize());
            return resourceTypeMapper.page(page,queryVo);
        }
        throw new SmartCodeException(ResultCodeEnum.PARAM_ERROR);
    }
}




