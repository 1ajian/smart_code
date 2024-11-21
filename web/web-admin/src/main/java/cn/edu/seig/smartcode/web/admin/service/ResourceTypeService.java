package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.ResourceDetailType;
import cn.edu.seig.smartcode.model.entity.ResourceType;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourcePageQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourceTypeVo;
import cn.edu.seig.smartcode.web.admin.vo.resource.ResourcesTypeVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【resource_type(资料类型表 例如软考)】的数据库操作Service
* @createDate 2024-11-16 20:35:50
*/
public interface ResourceTypeService extends IService<ResourceType> {

    /**
     * 根据Id删除资源类型
     * @param id
     */
    void deleteById(Long id);

    /**
     * 条件和分页查询资料类型和资料具体类型
     * @param queryVo
     * @return
     */
    IPage<ResourcesTypeVo> getTypePage(ResourceTypeVo queryVo);
}
