package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.login.LoginUserHolder;
import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.model.entity.Lesson;
import cn.edu.seig.smartcode.model.entity.LessonType;
import cn.edu.seig.smartcode.model.entity.TechnologyStack;
import cn.edu.seig.smartcode.model.entity.TypeStack;
import cn.edu.seig.smartcode.web.admin.service.LessonService;
import cn.edu.seig.smartcode.web.admin.service.LessonTypeService;
import cn.edu.seig.smartcode.web.admin.service.TechnologyStackService;
import cn.edu.seig.smartcode.web.admin.service.TypeStackService;

import cn.edu.seig.smartcode.web.admin.vo.lesson.LessonInfoVo;
import cn.edu.seig.smartcode.web.admin.vo.lesson.UpdateTypeOrStackVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageDetailLessonQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageLesAndTecQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: lessonController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/19 17:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/lesson")
@Tag(name = "课程管理")
@CrossOrigin
@Slf4j
public class lessonController {

    @Autowired
    private LessonTypeService lessonTypeService;

    @Autowired
    private TechnologyStackService technologyStackService;

    @Autowired
    private TypeStackService typeStackService;

    @Autowired
    private LessonService lessonService;

    @GetMapping("/page/lessonAndTechology")
    @Operation(summary = "分页查询课程类型和技术栈信息")
    public Result<PageResultVo> getPage(PageLesAndTecQueryVo pageLesAndTecQueryVo) {
        PageResultVo result = lessonTypeService.getPage(pageLesAndTecQueryVo);
        return Result.ok(result);
    }

    @GetMapping("/allType")
    @Operation(summary = "获取所有课程类型")
    public Result<List<LessonType>> getLessonType() {
        List<LessonType> list = lessonTypeService.list();
        return Result.ok(list);
    }

    @GetMapping("/getStackByType")
    @Operation(summary = "通过类型id获取所有技术栈")
    public Result<List<TechnologyStack>> getStackByTypeid(Long id) {
        List<TechnologyStack> list = technologyStackService.getByTypeId(id);
        return Result.ok(list);
    }

    @PostMapping("/addorUpdateLessonType")
    @Operation(summary = "添加或者修改课程类型")
    //改个名称
    public Result addorUpdateLessonType(@RequestBody LessonType lessonType) {
        lessonType.setCreateAdminId(LoginUserHolder.getLoginUser().getUserId());
        lessonTypeService.saveOrUpdate(lessonType);
        return Result.ok();
    }

    @PostMapping("/addorUpdateStack")
    @Operation(summary = "添加或者修改技术栈")
    //改个名称
    public Result saveOrUpdateStack(@RequestBody TechnologyStack technologyStack) {
        technologyStackService.saveOrUpdate(technologyStack);
        return Result.ok();
    }

    @PostMapping("/addSameTime")
    @Operation(summary = "同时添加课程类型和技术栈")
    public Result savelessonTypeAndStack(@RequestBody TypeStack typeStack) {
        typeStackService.save(typeStack);
        return Result.ok();
    }

    @PostMapping("/updateLessonTypeOrStack")
    @Operation(summary = "更新课程类型或者技术栈")
    public Result updateLessonTypeOrStack(@RequestBody UpdateTypeOrStackVo updateTypeOrStackVo) {
        typeStackService.updateLessonTypeOrStack(updateTypeOrStackVo);
        return Result.ok();
    }

    @DeleteMapping("/deleteTypeAndStack")
    @Operation(summary = "同时删除课程类型和技术栈信息")
    public Result removeTypeAndStack(@RequestParam Long typeId,@RequestParam Long stackId) {
        typeStackService.removeTypeAndStack(typeId,stackId);
        return Result.ok();
    }

    @GetMapping("/page/lesson")
    @Operation(summary = "分页查询课程列表信息")
    public Result<PageResultVo> lessonList(PageDetailLessonQueryVo pageDetailLessonQueryVo) {
        PageResultVo pageResultVo = lessonService.getPage(pageDetailLessonQueryVo);
        return Result.ok(pageResultVo);
    }

    @GetMapping("/getLessinfo")
    @Operation(summary = "根据具体课程Id展示课程信息")
    public Result<LessonInfoVo> getLessonInfoVo(Long id) {
        LessonInfoVo lessonInfoVo = lessonService.getLessonInfoById(id);
        return Result.ok(lessonInfoVo);
    }

    @PutMapping("/updateLesson")
    @Operation(summary = "更新课程信息")
    public Result updateLesson(@RequestBody LessonInfoVo lessonInfoVo) {
        lessonService.updateLesson(lessonInfoVo);
        return Result.ok();
    }

    @PostMapping("/saveLesson")
    @Operation(summary = "保存课程信息")
    public Result saveLesson(@RequestBody LessonInfoVo lessonInfoVo) {
        lessonService.saveLesson(lessonInfoVo);
        return Result.ok();
    }

    @DeleteMapping("/removeLesson")
    @Operation(summary = "删除课程信息")
    public Result removeLesson(Long id) {
        lessonService.removeById(id);
        return Result.ok();
    }

}
