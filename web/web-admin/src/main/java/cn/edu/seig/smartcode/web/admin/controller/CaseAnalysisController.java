package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.web.admin.service.CaseAnalysisService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageCaseAnalysisQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: CaseAnalysisController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 18:38
 * @Version 1.0
 */
@Slf4j
@RestController
@CrossOrigin
@Tag(name = "案例分析管理")
@RequestMapping("/admin/analysis")
public class CaseAnalysisController {

    @Autowired
    private CaseAnalysisService caseAnalysisService;

    @GetMapping("/page")
    @Operation(summary = "分页查询案例分析")
    public Result<PageResultVo> getPage(PageCaseAnalysisQueryVo analysisQueryVo) {
        PageResultVo result = caseAnalysisService.getPage(analysisQueryVo);
        return Result.ok(result);
    }

    @DeleteMapping("/remove")
    @Operation(summary = "删除案例分析")
    public Result removeCaseAnalysis(Long id) {
        caseAnalysisService.removeById(id);
        return Result.ok();
    }

}
