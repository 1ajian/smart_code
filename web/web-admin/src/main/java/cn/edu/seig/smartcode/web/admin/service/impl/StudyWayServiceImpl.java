package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.Lesson;
import cn.edu.seig.smartcode.model.entity.SystemUser;
import cn.edu.seig.smartcode.model.entity.TechnologyStack;
import cn.edu.seig.smartcode.web.admin.mapper.StudyWayMapper;
import cn.edu.seig.smartcode.web.admin.service.StudyWayService;
import cn.edu.seig.smartcode.web.admin.service.SystemUserService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageStudyWayLessonQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageStudyWayQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageWayLessonVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.seig.smartcode.model.entity.StudyWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86135
* @description 针对表【study_way(学习路线表)】的数据库操作Service实现
* @createDate 2024-11-18 01:25:17
*/
@Service
public class StudyWayServiceImpl extends ServiceImpl<StudyWayMapper, StudyWay>
    implements StudyWayService {

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private StudyWayMapper studyWayMapper;

    @Override
    public PageResultVo getPage(PageStudyWayQueryVo queryVo) {
        Page<StudyWay> page = new Page<>(queryVo.getPage(), queryVo.getPageSize());
        page = lambdaQuery().like(StringUtils.isNotBlank(queryVo.getName()),StudyWay::getName,queryVo.getName())
                .gt(queryVo.getBeginTime() != null,StudyWay::getCreateTime,queryVo.getBeginTime())
                .lt(queryVo.getEndTime() != null,StudyWay::getCreateTime,queryVo.getEndTime())
                .page(page);
        List<StudyWay> records = page.getRecords();
        records.forEach(studyWay -> {
            Long adminId = studyWay.getUploadAdminId();
            SystemUser user = systemUserService.getById(adminId);
            studyWay.setUsername(user.getUsername());
        });
        return PageResultVo.builder().total(page.getTotal()).records(records).build();
    }

    @Override
    public PageResultVo getLessonBywayId(PageStudyWayLessonQueryVo queryVo) {
        IPage<PageWayLessonVo> page = new Page<>(queryVo.getPage(), queryVo.getPageSize());
        page = studyWayMapper.page(page,queryVo);
        return PageResultVo.builder().total(page.getTotal()).records(page.getRecords()).build();
    }
}




