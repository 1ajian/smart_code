package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.Resource;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourcePageQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【resource(资料信息表 ,具体资料 比如软件设计师24和25年真题)】的数据库操作Service
* @createDate 2024-11-16 20:35:50
*/
public interface ResourceService extends IService<Resource> {

    /**
     * 获取分页数据
     * @param pageQueryVo
     * @return
     */
    PageResultVo getPage(ResourcePageQueryVo pageQueryVo);
}
