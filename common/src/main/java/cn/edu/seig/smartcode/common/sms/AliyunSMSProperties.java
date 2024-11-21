package cn.edu.seig.smartcode.common.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: AliyunSMSProperties
 * Package: cn.edu.seig.smartcode.common.sms
 * Description:
 *      阿里云sms配置参数
 * @Author 阿小健
 * @Create 2024/11/16 14:48
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunSMSProperties {
    private String accessKeyId;

    private String accessKeySecret;

    private String endpoint;
}
