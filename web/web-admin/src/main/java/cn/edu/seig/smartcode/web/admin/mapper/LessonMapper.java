package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.Lesson;
import cn.edu.seig.smartcode.web.admin.vo.page.PageDetailLessonQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageLessonVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author 86135
* @description 针对表【lesson(具体课程表 例如具体 React18 等课程)】的数据库操作Mapper
* @createDate 2024-11-16 20:40:26
* @Entity cn.edu.seig.smartcode.model.entity.Lesson
*/
public interface LessonMapper extends BaseMapper<Lesson> {
    /**
     * 根据技术栈Id分页查询具体课程信息
     * @param page
     * @param queryVo
     * @return
     */
    IPage<PageLessonVo> page(IPage<PageLessonVo> page, PageDetailLessonQueryVo queryVo);

    /**
     * 获取已删除课程
     * @return
     */
    Long getNotListedLessonCount();
}




