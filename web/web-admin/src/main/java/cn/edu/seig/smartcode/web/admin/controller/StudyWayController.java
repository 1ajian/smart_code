package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.login.LoginUser;
import cn.edu.seig.smartcode.common.login.LoginUserHolder;
import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.model.entity.StudyWay;
import cn.edu.seig.smartcode.model.entity.WayStack;
import cn.edu.seig.smartcode.web.admin.service.StudyWayService;
import cn.edu.seig.smartcode.web.admin.service.WayStackService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageStudyWayLessonQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageStudyWayQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.waystack.WayStackVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.source.doctree.SummaryTree;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: StudyWayController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 20:27
 * @Version 1.0
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/admin/studyway")
@Tag(name = "学习路线管理")
public class StudyWayController {

    @Autowired
    private StudyWayService studyWayService;

    @Autowired
    private WayStackService wayStackService;

    @GetMapping("/studyway")
    @Operation(summary = "分页获取所有学习路线")
    public Result<PageResultVo> getPage(PageStudyWayQueryVo pageStudyWayQueryVo) {
        PageResultVo pageResultVo = studyWayService.getPage(pageStudyWayQueryVo);
        return Result.ok(pageResultVo);
    }

    @PostMapping("/studyway")
    @Operation(summary = "添加学习路线")
    public Result saveStudyWay(@RequestBody StudyWay studyWay) {
        studyWay.setUploadAdminId(LoginUserHolder.getLoginUser().getUserId());
        studyWayService.save(studyWay);
        return Result.ok();
    }

    @DeleteMapping("/studyway/{id}")
    @Operation(summary = "删除学习路线")
    public Result removeStudyWay(@PathVariable Long id) {
        studyWayService.removeById(id);
        return Result.ok();
    }

    @PutMapping("/studyway")
    @Operation(summary = "修改学习路线")
    public Result updateStudyway(@RequestBody StudyWay studyWay) {
        studyWayService.updateById(studyWay);
        return Result.ok();
    }

    @Operation(summary = "根据路线id查询学习路线关联的所有技术栈")
    @GetMapping("/getLessonBywayId")
    public Result<PageResultVo> getLessonBywayId(PageStudyWayLessonQueryVo queryVo) {
        PageResultVo pageResultVo = studyWayService.getLessonBywayId(queryVo);
        return Result.ok(pageResultVo);
    }

    @Operation(summary = "添加学习路线中的技术栈")
    @PostMapping("/addStackForWay")
    public Result saveStackForWay(@RequestBody WayStack wayStack) {
        if (wayStack.getUploadAdminId() == null) {
            wayStack.setUploadAdminId(LoginUserHolder.getLoginUser().getUserId());

        }
        wayStackService.save(wayStack);
        return Result.ok();
    }

    @Operation(summary = "删除学习路线中的技术栈")
    @DeleteMapping("/removeStackForWay")
    public Result removeStackForWay(Long wayId,Long stackId) {
        LambdaQueryWrapper<WayStack> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WayStack::getStackId,stackId).eq(WayStack::getWayId,wayId);
        wayStackService.remove(wrapper);
        return Result.ok();
    }

    @Operation(summary = "更新学习路线中的技术栈")
    @PutMapping("/updateStackForWay")
    public Result updateStackForWay(@RequestBody WayStackVo wayStackVo) {
        wayStackService.updateStackForWay(wayStackVo);
        return Result.ok();
    }
}
