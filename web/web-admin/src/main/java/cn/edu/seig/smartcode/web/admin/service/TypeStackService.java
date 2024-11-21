package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.TypeStack;
import cn.edu.seig.smartcode.web.admin.vo.lesson.UpdateTypeOrStackVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【type_stack(课程和技术栈联系表)】的数据库操作Service
* @createDate 2024-11-16 20:35:51
*/
public interface TypeStackService extends IService<TypeStack> {


    /**
     * 更新课程类型或者技术栈
     * @param updateTypeOrStackVo
     */
    void updateLessonTypeOrStack(UpdateTypeOrStackVo updateTypeOrStackVo);

    /**
     * 同时删除课程类型和技术栈信息
     * @param typeId
     * @param stackId
     */
    void removeTypeAndStack(Long typeId, Long stackId);
}
