package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.LessonType;
import cn.edu.seig.smartcode.web.admin.vo.page.PageLesAndTecQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageLesAndTecVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author 86135
* @description 针对表【lesson_type(课程类型表)】的数据库操作Mapper
* @createDate 2024-11-16 20:40:26
* @Entity cn.edu.seig.smartcode.model.entity.LessonType
*/
public interface LessonTypeMapper extends BaseMapper<LessonType> {

    /**
     * 分页查询课程类型和技术栈
     * @param page
     * @param pageQueryVo
     * @return
     */
    IPage<PageLesAndTecVo> page(IPage<PageLesAndTecVo> page, PageLesAndTecQueryVo pageQueryVo);
}




