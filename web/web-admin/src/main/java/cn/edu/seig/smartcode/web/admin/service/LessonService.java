package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.Lesson;
import cn.edu.seig.smartcode.web.admin.vo.lesson.LessonInfoVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageDetailLessonQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.report.LessonOverviewVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【lesson(具体课程表 例如具体 React18 等课程)】的数据库操作Service
* @createDate 2024-11-16 20:35:50
*/
public interface LessonService extends IService<Lesson> {

    /**
     * 根据技术栈Id分页查询具体课程信息
     * @param pageDetailLessonQueryVo
     * @return
     */
    PageResultVo getPage(PageDetailLessonQueryVo pageDetailLessonQueryVo);

    /**
     * 根据具体课程Id展示课程信息
     * @param id
     * @return
     */
    LessonInfoVo getLessonInfoById(Long id);

    /**
     * 更新课程信息
     * @param lessonInfoVo
     */
    void updateLesson(LessonInfoVo lessonInfoVo);

    /**
     * 保存课程信息
     * @param lessonInfoVo
     */
    void saveLesson(LessonInfoVo lessonInfoVo);

    /**
     * 课程总览
     * @return
     */
    LessonOverviewVo getLessonOverview();
}
