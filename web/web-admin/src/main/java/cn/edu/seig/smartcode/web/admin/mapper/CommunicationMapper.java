package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.Communication;
import cn.edu.seig.smartcode.web.admin.vo.communication.CommunicationVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageCommunicationQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author 86135
* @description 针对表【communication(社区交流表)】的数据库操作Mapper
* @createDate 2024-11-16 20:40:26
* @Entity cn.edu.seig.smartcode.model.entity.Communication
*/
public interface CommunicationMapper extends BaseMapper<Communication> {

    /**
     * 社区交流分页查询
     * @param page
     * @param queryVo
     * @return
     */
    IPage<CommunicationVo> page(IPage<CommunicationVo> page, PageCommunicationQueryVo queryVo);
}




