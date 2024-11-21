package cn.edu.seig.smartcode.web.admin.service;

import org.springframework.web.multipart.MultipartFile;


/**
 * ClassName: FileService
 * Package: cn.edu.seig.smartcode.web.admin.service
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 11:26
 * @Version 1.0
 */
public interface FileService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    String upload(MultipartFile file) ;
}
