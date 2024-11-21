package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.TechnologyStack;
import cn.edu.seig.smartcode.web.admin.mapper.TechnologyStackMapper;
import cn.edu.seig.smartcode.web.admin.service.TechnologyStackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86135
* @description 针对表【technology_stack(技术栈表 比如vue或者是react)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:27
*/
@Service
public class TechnologyStackServiceImpl extends ServiceImpl<TechnologyStackMapper, TechnologyStack>
    implements TechnologyStackService {

    @Autowired
    private TechnologyStackMapper technologyStackMapper;

    @Override
    public List<TechnologyStack> getByTypeId(Long id) {
        List<TechnologyStack> list = technologyStackMapper.getByTypeId(id);
        return list;
    }
}




