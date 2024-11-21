package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.ResourceDetailType;
import cn.edu.seig.smartcode.model.entity.ResourceType;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourcePageQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourceTypeVo;
import cn.edu.seig.smartcode.web.admin.vo.resource.ResourcesTypeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author 86135
* @description 针对表【resource_type(资料类型表 例如软考)】的数据库操作Mapper
* @createDate 2024-11-16 20:40:27
* @Entity cn.edu.seig.smartcode.model.entity.ResourceType
*/
public interface ResourceTypeMapper extends BaseMapper<ResourceType> {

    /**
     * 条件和分页查询资料类型和资料具体类型
     * @param page
     * @param queryVo
     * @return
     */
    IPage<ResourcesTypeVo> page(IPage<ResourcesTypeVo> page, @Param("queryVo") ResourceTypeVo queryVo);
}




