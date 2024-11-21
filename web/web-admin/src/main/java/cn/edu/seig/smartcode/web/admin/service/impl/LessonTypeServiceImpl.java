package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.LessonType;
import cn.edu.seig.smartcode.web.admin.mapper.LessonTypeMapper;
import cn.edu.seig.smartcode.web.admin.service.LessonTypeService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageLesAndTecQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageLesAndTecVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86135
* @description 针对表【lesson_type(课程类型表)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:26
*/
@Service
public class LessonTypeServiceImpl extends ServiceImpl<LessonTypeMapper, LessonType>
    implements LessonTypeService {

    @Autowired
    private LessonTypeMapper lessonTypeMapper;

    @Override
    public PageResultVo getPage(PageLesAndTecQueryVo pageQueryVo) {
        IPage<PageLesAndTecVo> page = new Page<>(pageQueryVo.getPage(), pageQueryVo.getPageSize());
        page = lessonTypeMapper.page(page,pageQueryVo);

        return PageResultVo.builder().total(page.getTotal()).records(page.getRecords()).build();
    }
}




