package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.web.admin.service.*;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.report.AllDataVo;
import cn.edu.seig.smartcode.web.admin.vo.report.LessonOverviewVo;
import cn.edu.seig.smartcode.web.admin.vo.report.UserOverview;
import cn.edu.seig.smartcode.web.admin.vo.report.UserReportVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * ClassName: ReportController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/21 0:43
 * @Version 1.0
 */
@CrossOrigin
@RestController
@Tag(name = "数据统计相关")
@RequestMapping("/admin/report")
public class ReportController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private StudyWayService studyWayService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CaseAnalysisService caseAnalysisService;
    @GetMapping("/allData")
    @Operation(summary = "各总数数据")
    public Result<AllDataVo> getAllData()  {
        long lessonCount = lessonService.count();
        long resourceCount = resourceService.count();
        long studywayCount = studyWayService.count();
        long caseAnalysisCount = caseAnalysisService.count();
        AllDataVo allDataVo = AllDataVo.builder().caseAnalysisCount(caseAnalysisCount).lessonCount(lessonCount).resourceCount(resourceCount).wayCount(studywayCount)
                .build();
        return Result.ok(allDataVo);
    }

    @GetMapping("/getLessonOverview")
    @Operation(summary = "课程总览")
    public Result<LessonOverviewVo> getLessonOverview()  {
        LessonOverviewVo lessonOverviewVo = lessonService.getLessonOverview();
        return Result.ok(lessonOverviewVo);
    }

    @GetMapping("/getUserOverview")
    @Operation(summary = "用户总览")
    public Result<UserOverview> getUserOverview(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate today) {
        UserOverview userOverview = userInfoService.getUserOverview(today);
        return Result.ok(userOverview);
    }

    @GetMapping("/getUserReportVo")
    @Operation(summary = "用户人数统计echarts")
    public Result<UserReportVo> getUserReportVo(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        UserReportVo userReportVo = userInfoService.getUserReportVo(begin,end);
        return Result.ok(userReportVo);
    }
}
