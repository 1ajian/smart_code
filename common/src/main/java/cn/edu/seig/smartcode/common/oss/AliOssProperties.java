package cn.edu.seig.smartcode.common.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: AliOssProperties
 * Package: cn.edu.seig.smartcode.common.oss
 * Description:
 *  oss配置参数
 * @Author 阿小健
 * @Create 2024/11/16 15:23
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOssProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
