package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.common.login.LoginUserHolder;
import cn.edu.seig.smartcode.model.entity.GraphInfo;
import cn.edu.seig.smartcode.model.entity.Lesson;
import cn.edu.seig.smartcode.model.entity.Resource;
import cn.edu.seig.smartcode.model.enums.ItemType;
import cn.edu.seig.smartcode.web.admin.mapper.LessonMapper;
import cn.edu.seig.smartcode.web.admin.service.GraphInfoService;
import cn.edu.seig.smartcode.web.admin.service.LessonService;
import cn.edu.seig.smartcode.web.admin.service.ResourceService;
import cn.edu.seig.smartcode.web.admin.vo.lesson.LessonInfoVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageDetailLessonQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageLessonVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.report.LessonOverviewVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86135
* @description 针对表【lesson(具体课程表 例如具体 React18 等课程)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:26
*/
@Service
public class LessonServiceImpl extends ServiceImpl<LessonMapper, Lesson>
    implements LessonService {

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private GraphInfoService graphInfoService;
    @Override
    public PageResultVo getPage(PageDetailLessonQueryVo queryVo) {
        IPage<PageLessonVo> page = new Page<>(queryVo.getPage(),queryVo.getPageSize());
        page = lessonMapper.page(page,queryVo);
        return PageResultVo.builder().total(page.getTotal()).records(page.getRecords()).build();
    }

    @Override
    public LessonInfoVo getLessonInfoById(Long id) {
        Lesson lesson = getById(id);
        LambdaQueryWrapper<GraphInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GraphInfo::getItemType, ItemType.LESSONTYPE)
                        .eq(GraphInfo::getItemId,id);
        List<GraphInfo> graphInfos = graphInfoService.list(wrapper);
        Long resourceId = lesson.getResourceId();
        Resource resource = resourceService.getById(resourceId);
        LessonInfoVo infoVo = null;
        if (resource != null) {
            if (StringUtils.isNotBlank(resource.getUrl())) {
                infoVo = new LessonInfoVo(graphInfos, resource.getUrl());
            }
        } else {
            infoVo = new LessonInfoVo(graphInfos, null);
        }
        BeanUtils.copyProperties(lesson, infoVo);
        return infoVo;
    }

    @Override
    public void updateLesson(LessonInfoVo lessonInfoVo) {
        Lesson lesson = new Lesson();
        BeanUtils.copyProperties(lessonInfoVo, lesson);
        LambdaUpdateWrapper<Lesson> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Lesson::getId, lesson.getId());
        update(lesson,updateWrapper);
        Long resourceId = lesson.getResourceId();
        String resourceUrl = lessonInfoVo.getResourceUrl();
        LambdaUpdateWrapper<Resource> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(resourceUrl != null,Resource::getUrl,resourceUrl).eq(resourceId != null, Resource::getId,resourceId);
        resourceService.update(wrapper);
        List<GraphInfo> faceUrl = lessonInfoVo.getFaceUrl();
        if (faceUrl != null) {
            LambdaQueryWrapper<GraphInfo> graphInfoWrapper = new LambdaQueryWrapper<>();
            graphInfoWrapper.eq(GraphInfo::getItemId, lesson.getId())
                            .eq(GraphInfo::getItemType, ItemType.LESSONTYPE);
            graphInfoService.remove(graphInfoWrapper);

            faceUrl.forEach(graphInfo -> {
                if (graphInfo.getItemId() == null) {
                    graphInfo.setItemId(lesson.getId());
                }

                if (graphInfo.getItemType() == null) {
                    graphInfo.setItemType(ItemType.LESSONTYPE);
                }
            });
            graphInfoService.saveBatch(faceUrl);
        }
    }

    @Override
    public void saveLesson(LessonInfoVo lessonInfoVo) {
        String resourceUrl = lessonInfoVo.getResourceUrl();
        int index = resourceUrl.lastIndexOf("-");
        String name = resourceUrl.substring(index + 1);
        Resource resource = new Resource();
        resource.setName(name);
        resource.setUrl(resourceUrl);
        resource.setUploadAdminId(LoginUserHolder.getLoginUser().getUserId());
        resourceService.save(resource);

        Lesson lesson = new Lesson();
        BeanUtils.copyProperties(lessonInfoVo, lesson);
        lesson.setResourceId(resource.getId());
        save(lesson);

        List<GraphInfo> faceUrl = lessonInfoVo.getFaceUrl();
        if (faceUrl != null) {
            faceUrl.forEach(graphInfo -> {
                if (StringUtils.isBlank(graphInfo.getName())) {
                    String url = graphInfo.getUrl();
                    if (StringUtils.isNotBlank(url)) {
                        int i = url.lastIndexOf("-");
                        String graphName = url.substring(i + 1);
                        graphInfo.setName(graphName);
                    }
                }

                if (graphInfo.getItemType() == null) {
                    graphInfo.setItemType(ItemType.LESSONTYPE);
                }


                graphInfo.setItemId(lesson.getId());

            });

            graphInfoService.saveBatch(faceUrl);
        }

    }

    @Override
    public LessonOverviewVo getLessonOverview() {
        Long alreadyListedCount = count();
        Long notListCount  = lessonMapper.getNotListedLessonCount();
        Long allLessonCount = alreadyListedCount + notListCount;
        return LessonOverviewVo.builder().allLessonCount(allLessonCount).alreadyListedCount(alreadyListedCount).notListCount(notListCount).build();
    }


}




