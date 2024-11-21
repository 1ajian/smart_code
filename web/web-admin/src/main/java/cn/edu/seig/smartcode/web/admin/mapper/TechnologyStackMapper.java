package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.TechnologyStack;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 86135
* @description 针对表【technology_stack(技术栈表 比如vue或者是react)】的数据库操作Mapper
* @createDate 2024-11-16 20:40:27
* @Entity cn.edu.seig.smartcode.model.entity.TechnologyStack
*/
public interface TechnologyStackMapper extends BaseMapper<TechnologyStack> {

    /**
     * 根据类型id获取所有技术栈
     * @param id
     * @return
     */
    List<TechnologyStack> getByTypeId(Long id);
}




