package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.model.entity.Carousel;
import cn.edu.seig.smartcode.web.admin.service.CarouselService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: carouselController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/21 16:45
 * @Version 1.0
 */
@Slf4j
@CrossOrigin
@RestController
@Tag(name = "轮播图管理")
@RequestMapping("/admin/carousel")
public class carouselController {
    @Autowired
    private CarouselService carouselService;

    @GetMapping("/carousel")
    @Operation(summary = "获取当前所有的轮播图")
    public Result<List<Carousel>> getAll() {
        List<Carousel> list = carouselService.list();
        return Result.ok(list);
    }

    @DeleteMapping("/carousel")
    @Operation(summary = "删除轮播图")
    public Result removeCarousel(Long id) {
        carouselService.removeById(id);
        return Result.ok();
    }

    @PostMapping("/carousel")
    @Operation(summary = "添加轮播图")
    public Result saveCarousel(@RequestBody Carousel carousel) {
        carouselService.save(carousel);
        return Result.ok();
    }

    @PutMapping("/carousel")
    @Operation(summary = "更新轮播图")
    public Result updateCarousel(@RequestBody List<Carousel> carousels) {
        carouselService.remove(null);
        carouselService.saveBatch(carousels);
        return Result.ok();
    }
}
