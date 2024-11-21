package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.LessonType;
import cn.edu.seig.smartcode.web.admin.vo.page.PageLesAndTecQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【lesson_type(课程类型表)】的数据库操作Service
* @createDate 2024-11-16 20:35:50
*/
public interface LessonTypeService extends IService<LessonType> {

    /**
     * 分页查询课程类型和技术栈
     * @return
     */
    PageResultVo getPage(PageLesAndTecQueryVo pageLesAndTecQueryVo);
}
