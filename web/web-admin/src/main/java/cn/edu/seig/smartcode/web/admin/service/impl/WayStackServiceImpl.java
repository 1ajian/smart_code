package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.web.admin.mapper.WayStackMapper;
import cn.edu.seig.smartcode.web.admin.service.WayStackService;
import cn.edu.seig.smartcode.web.admin.vo.waystack.WayStackVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.seig.smartcode.model.entity.WayStack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86135
* @description 针对表【way_stack(学习路线与技术栈的中间表)】的数据库操作Service实现
* @createDate 2024-11-18 01:25:17
*/
@Slf4j
@Service
public class WayStackServiceImpl extends ServiceImpl<WayStackMapper, WayStack>
    implements WayStackService {

    @Autowired
    private WayStackMapper wayStackMapper;

    @Override
    public void updateStackForWay(WayStackVo wayStackVo) {
        log.info("参数:{}",wayStackVo);
        Long newStackId = wayStackVo.getNewStackId();
        Long newWayId = wayStackVo.getNewWayId();
        Long oldStackId = wayStackVo.getOldStackId();
        Long oldWayId = wayStackVo.getOldWayId();
        LambdaUpdateWrapper<WayStack> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(WayStack::getWayId,newWayId)
                .eq(WayStack::getStackId,oldStackId).eq(WayStack::getWayId,oldWayId).set(WayStack::getStackId, newStackId);
        update(wrapper);

    }
}




