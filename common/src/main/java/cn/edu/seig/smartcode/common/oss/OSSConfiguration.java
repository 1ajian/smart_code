package cn.edu.seig.smartcode.common.oss;

import cn.edu.seig.smartcode.common.oss.AliOssProperties;
import cn.edu.seig.smartcode.common.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: OSSConfiguration
 * Package: cn.edu.seig.smartcode.web.admin.custom.config
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 11:12
 * @Version 1.0
 */
@Slf4j
@Configuration
public class OSSConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties) {
        log.info("开始初始化阿里云OSS上传文件工具类");
        return new AliOssUtil(aliOssProperties.getEndpoint(),
                aliOssProperties.getAccessKeyId(),
                aliOssProperties.getAccessKeySecret(),
                aliOssProperties.getBucketName());
    }
}
