package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.Communication;
import cn.edu.seig.smartcode.web.admin.mapper.CommunicationMapper;
import cn.edu.seig.smartcode.web.admin.service.CommunicationService;
import cn.edu.seig.smartcode.web.admin.vo.communication.CommunicationVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageCommunicationQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86135
* @description 针对表【communication(社区交流表)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:26
*/
@Service
public class CommunicationServiceImpl extends ServiceImpl<CommunicationMapper, Communication>
    implements CommunicationService {

    @Autowired
    private CommunicationMapper communicationMapper;
    @Override
    public PageResultVo getPage(PageCommunicationQueryVo queryVo) {
        IPage<CommunicationVo> page = new Page<>(queryVo.getPage(), queryVo.getPageSize());
        page = communicationMapper.page(page,queryVo);
        return PageResultVo.builder().total(page.getTotal()).records(page.getRecords()).build();
    }

}




