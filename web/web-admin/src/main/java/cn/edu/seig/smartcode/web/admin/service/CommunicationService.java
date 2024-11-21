package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.Communication;
import cn.edu.seig.smartcode.web.admin.vo.page.PageCommunicationQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【communication(社区交流表)】的数据库操作Service
* @createDate 2024-11-16 20:35:50
*/
public interface CommunicationService extends IService<Communication> {

    /**
     * 社区交流分页查询
     * @param pageCommunicationQueryVo
     * @return
     */
    PageResultVo getPage(PageCommunicationQueryVo pageCommunicationQueryVo);
}
