package cn.edu.seig.smartcode.web.admin.controller;

import cn.edu.seig.smartcode.common.result.Result;
import cn.edu.seig.smartcode.web.admin.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ClassName: CommonController
 * Package: cn.edu.seig.smartcode.web.admin.controller
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 11:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/file")
@Tag(name = "文件管理")
@CrossOrigin
@Slf4j
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @Operation(summary = "上传文件")
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam MultipartFile file) {
        String url = fileService.upload(file);
        return Result.ok(url);
    }
}
