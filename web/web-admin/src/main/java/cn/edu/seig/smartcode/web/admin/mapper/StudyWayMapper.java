package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.StudyWay;
import cn.edu.seig.smartcode.model.entity.TechnologyStack;
import cn.edu.seig.smartcode.web.admin.vo.page.PageStudyWayLessonQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageWayLessonVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author 86135
* @description 针对表【study_way(学习路线表)】的数据库操作Mapper
* @createDate 2024-11-18 01:25:17
* @Entity cn.edu.seig.smartcode.model.entity.StudyWay
*/
public interface StudyWayMapper extends BaseMapper<StudyWay> {

    /**
     * 根据路线id查询学习路线关联的所有课程
     * @param page
     * @param queryVo
     * @return
     */
    IPage<PageWayLessonVo> page(IPage<PageWayLessonVo> page, PageStudyWayLessonQueryVo queryVo);
}




