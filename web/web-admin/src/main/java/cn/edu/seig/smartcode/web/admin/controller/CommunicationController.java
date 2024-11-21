package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.model.entity.Communication;
import cn.edu.seig.smartcode.model.entity.CommunicationType;
import cn.edu.seig.smartcode.web.admin.service.CommunicationService;
import cn.edu.seig.smartcode.web.admin.service.CommunicationTypeService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageCommunicationQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: CommunicationController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 15:51
 * @Version 1.0
 */
@Slf4j
@CrossOrigin
@RestController
@Tag(name = "社区交流管理")
@RequestMapping("/admin/communication")
public class CommunicationController {

    @Autowired
    private CommunicationService communicationService;

    @Autowired
    private CommunicationTypeService communicationTypeService;

    @GetMapping("/page")
    @Operation(summary = "社区交流分页查询")
    public Result<PageResultVo> getPage(PageCommunicationQueryVo pageCommunicationQueryVo) {
        PageResultVo pageResultVo = communicationService.getPage(pageCommunicationQueryVo);
        return Result.ok(pageResultVo);
    }

    @GetMapping("/types")
    @Operation(summary = "获取所有社区交流文章类型")
    public Result<List<CommunicationType>> getTypes() {
        List<CommunicationType> list = communicationTypeService.list();
        return Result.ok(list);
    }

    @DeleteMapping("/communication")
    @Operation(summary = "删除社区交流信息")
    public Result remove(Long id) {
        communicationService.removeById(id);
        return Result.ok();
    }
}
