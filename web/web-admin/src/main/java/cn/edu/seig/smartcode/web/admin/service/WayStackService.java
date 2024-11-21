package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.WayStack;
import cn.edu.seig.smartcode.web.admin.vo.waystack.WayStackVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【way_stack(学习路线与技术栈的中间表)】的数据库操作Service
* @createDate 2024-11-18 01:25:17
*/
public interface WayStackService extends IService<WayStack> {

    /**
     * 更新学习路线中的技术栈
     * @param wayStackVo
     */
    void updateStackForWay(WayStackVo wayStackVo);
}
