package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.ResourceDetailType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【resource_detail_type(资料具体类型表 例如软考的软件设计师)】的数据库操作Service
* @createDate 2024-11-16 20:35:50
*/
public interface ResourceDetailTypeService extends IService<ResourceDetailType> {

    /**
     * 删除资料具体类型
     * @param id
     */
    void deleteById(Long id);
}
