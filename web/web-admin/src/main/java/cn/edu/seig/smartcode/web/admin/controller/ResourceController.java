package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.login.LoginUserHolder;
import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.model.entity.Resource;
import cn.edu.seig.smartcode.model.entity.ResourceDetailType;
import cn.edu.seig.smartcode.model.entity.ResourceType;
import cn.edu.seig.smartcode.web.admin.service.ResourceDetailTypeService;
import cn.edu.seig.smartcode.web.admin.service.ResourceService;
import cn.edu.seig.smartcode.web.admin.service.ResourceTypeService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourcePageQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.ResourceTypeVo;
import cn.edu.seig.smartcode.web.admin.vo.resource.ResourcesTypeVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: ResourceController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *  资料类型的添加，删除，修改，查看 比如：软考、计算机等级
 *  资料具体类型的添加、删除、修改、查看 比如:软考的软件设计师 计算机等级的计算机三级、计算机四级
 * @Author 阿小健
 * @Create 2024/11/17 14:46
 * @Version 1.0
 */
@Slf4j
@RestController
@CrossOrigin
@Tag(name = "资料管理")
@RequestMapping("/admin/resource")
public class ResourceController {
    @Autowired
    private ResourceTypeService resourceTypeService;

    @Autowired
    private ResourceDetailTypeService detailTypeService;

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/type")
    @Operation(summary = "添加或者修改资源类型")
    public Result<Long> addResourceType(@RequestBody ResourceType resourceType) {
        Long adminId = LoginUserHolder.getLoginUser().getUserId();
        resourceType.setUploadAdminId(adminId);
        resourceTypeService.saveOrUpdate(resourceType);
        return Result.ok(resourceType.getId());
    }

    @Operation(summary = "删除资源类型")
    @DeleteMapping("/type/{id}")
    public Result removeResourceType(@PathVariable Long id) {
        log.info("删除资源的id:{}",id);
        resourceTypeService.deleteById(id);
        return Result.ok();

    }

    @Operation(summary = "查看全部资源类型")
    @GetMapping("/type")
    //TODO:
    public Result<List<ResourceType>> listType() {
        List<ResourceType> list = resourceTypeService.list();
        return Result.ok(list);

    }

   /* @GetMapping("/detailType")
    @Operation(summary = "查看全部具体资源类型")
    public Result<List<ResourceDetailType>> listDetailType() {
        List<ResourceDetailType> list = detailTypeService.list();
        return Result.ok(list);
    }*/

    @PostMapping("/detailType")
    @Operation(summary = "添加或者修改具体资源类型")
    public Result<Long> saveOrUpdateDetailType(@RequestBody ResourceDetailType resourceDetailType) {
        Long uploadAdminId = resourceDetailType.getUploadAdminId();
        if (uploadAdminId == null) {
            resourceDetailType.setUploadAdminId(LoginUserHolder.getLoginUser().getUserId());
        }
        detailTypeService.saveOrUpdate(resourceDetailType);
        return Result.ok(resourceDetailType.getId());
    }

    @DeleteMapping("/detailType/{id}")
    @Operation(summary = "删除具体资源类型")
    public Result removeDetailType(@PathVariable Long id) {
        detailTypeService.deleteById(id);
        return Result.ok();
    }

    @GetMapping("/detailType")
    @Operation(summary = "根据资源类型id查询具体资源类型")
    public Result<List<ResourceDetailType>> listByTypeId(@RequestParam(required = false) Long typeId) {
        if (typeId == null) {
            List<ResourceDetailType> list = detailTypeService.list();
            return Result.ok(list);
        }
        LambdaQueryWrapper<ResourceDetailType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ResourceDetailType::getResourceTypeId,typeId);
        List<ResourceDetailType> list = detailTypeService.list(wrapper);
        return Result.ok(list);
    }

    @Operation(summary = "添加或者修改具体资源")
    @PostMapping
    public Result saveOrUpdateResource(@RequestBody Resource resource) {
        resourceService.saveOrUpdate(resource);
        return Result.ok();
    }

    @Operation(summary = "删除具体资源")
    @DeleteMapping("/{id}")
    public Result removeResource(@PathVariable Long id) {
        resourceService.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "分页查询资源和条件查询")
    @GetMapping("/page")
    public Result<PageResultVo> pageResource(ResourcePageQueryVo pageQueryVo) {
        PageResultVo pageResultVo = resourceService.getPage(pageQueryVo);
        return Result.ok(pageResultVo);
    }

    @Operation(summary = "根据Id查询具体资源")
    @GetMapping
    public Result<Resource> getResourceById(@RequestParam Long id) {
        Resource resource = resourceService.getById(id);
        return Result.ok(resource);
    }

    @Operation(summary = "获取资料类型和资料具体类型")
    @GetMapping("/resourceType")
    public Result<IPage<ResourcesTypeVo>> getTypePage(ResourceTypeVo queryVo) {
        IPage<ResourcesTypeVo> result = resourceTypeService.getTypePage(queryVo);
        return Result.ok(result);
    }
}
