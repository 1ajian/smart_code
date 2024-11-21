package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.common.exception.SmartCodeException;
import cn.edu.seig.smartcode.common.result.ResultCodeEnum;


import cn.edu.seig.smartcode.common.utils.AliOssUtil;
import cn.edu.seig.smartcode.web.admin.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * ClassName: FileServiceImpl
 * Package: cn.edu.seig.smartcode.web.admin.service.impl
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 11:27
 * @Version 1.0
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Autowired
    private AliOssUtil aliOssUtil;
    @Override
    public String upload(@RequestParam MultipartFile file)  {
      log.info("开始上传文件:{}",file);

      if (file == null) {
          return "";
      }
      String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
              + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();

      try {
          String filePath = aliOssUtil.upload(file.getBytes(), fileName);
          log.info("上传成功返回地址:{}",filePath);
          return filePath;
      } catch (Exception e) {
          log.info("文件上传输失败:{}",e.getMessage());
          throw new SmartCodeException(ResultCodeEnum.UPLOAD_ERROR);
      }

    }
}
