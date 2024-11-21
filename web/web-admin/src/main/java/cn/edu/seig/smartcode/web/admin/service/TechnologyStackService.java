package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.TechnologyStack;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86135
* @description 针对表【technology_stack(技术栈表 比如vue或者是react)】的数据库操作Service
* @createDate 2024-11-16 20:35:51
*/
public interface TechnologyStackService extends IService<TechnologyStack> {

    /**
     * 根据类型Id获取技术栈集合
     * @param id
     * @return
     */
    List<TechnologyStack> getByTypeId(Long id);
}
