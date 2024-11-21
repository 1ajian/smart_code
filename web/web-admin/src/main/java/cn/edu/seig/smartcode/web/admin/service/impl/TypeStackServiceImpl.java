package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.TypeStack;
import cn.edu.seig.smartcode.web.admin.mapper.TypeStackMapper;
import cn.edu.seig.smartcode.web.admin.service.TypeStackService;
import cn.edu.seig.smartcode.web.admin.vo.lesson.UpdateTypeOrStackVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author 86135
* @description 针对表【type_stack(课程和技术栈联系表)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:27
*/
@Service
public class TypeStackServiceImpl extends ServiceImpl<TypeStackMapper, TypeStack>
    implements TypeStackService {

    @Override
    public void updateLessonTypeOrStack(UpdateTypeOrStackVo updateTypeOrStackVo) {
        Long oldStackId = updateTypeOrStackVo.getOldStackId();
        Long oldTypeId = updateTypeOrStackVo.getOldTypeId();
        Long newStackId = updateTypeOrStackVo.getNewStackId();
        Long newTypeId = updateTypeOrStackVo.getNewTypeId();
        LambdaUpdateWrapper<TypeStack> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(oldTypeId != null ,TypeStack::getLessonTypeId,oldTypeId)
                .eq(oldStackId != null, TypeStack::getTechnologyStackId,oldStackId)
                .set((oldTypeId != null) && (newTypeId != null), TypeStack::getLessonTypeId,newTypeId)
                .set((oldStackId != null) && (newStackId != null),TypeStack::getTechnologyStackId,newStackId);
        update(wrapper);
    }

    @Override
    public void removeTypeAndStack(Long typeId, Long stackId) {
        LambdaQueryWrapper<TypeStack> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(typeId != null,TypeStack::getLessonTypeId,typeId)
                .eq(stackId != null,TypeStack::getTechnologyStackId,stackId);
        remove(wrapper);

    }
}




