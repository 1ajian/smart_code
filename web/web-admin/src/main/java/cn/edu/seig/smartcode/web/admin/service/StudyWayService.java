package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.StudyWay;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageStudyWayLessonQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageStudyWayQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【study_way(学习路线表)】的数据库操作Service
* @createDate 2024-11-18 01:25:17
*/
public interface StudyWayService extends IService<StudyWay> {

    /**
     * 分页获取所有学习路线
     * @param pageStudyWayQueryVo
     * @return
     */
    PageResultVo getPage(PageStudyWayQueryVo pageStudyWayQueryVo);

    /**
     * 根据路线id查询学习路线关联的所有课程
     * @param queryVo
     * @return
     */
    PageResultVo getLessonBywayId(PageStudyWayLessonQueryVo queryVo);
}
