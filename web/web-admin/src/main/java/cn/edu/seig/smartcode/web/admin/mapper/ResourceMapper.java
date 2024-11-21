package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.Resource;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourcePageQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* @author 86135
* @description 针对表【resource(资料信息表 ,具体资料 比如软件设计师24和25年真题)】的数据库操作Mapper
* @createDate 2024-11-16 20:40:26
* @Entity cn.edu.seig.smartcode.model.entity.Resource
*/
public interface ResourceMapper extends BaseMapper<Resource> {


    IPage<Resource> page(Page<Resource> page, ResourcePageQueryVo pageQueryVo);
}




