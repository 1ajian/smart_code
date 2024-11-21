package cn.edu.seig.smartcode.common.sms;

import cn.edu.seig.smartcode.common.sms.AliyunSMSProperties;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: AliyunSMSConfiguration
 * Package: cn.edu.seig.smartcode.common.sms
 * Description:
 *      阿里云sms配置类
 * @Author 阿小健
 * @Create 2024/11/16 14:50
 * @Version 1.0
 */
@Configuration
@EnableConfigurationProperties(AliyunSMSProperties.class)
@ConditionalOnProperty(name = "aliyun.sms.endpoint")
public class AliyunSMSConfiguration {

    @Autowired
    private AliyunSMSProperties properties;

    @Bean
    public Client createClient() {
        Config config = new Config()
                .setAccessKeyId(properties.getAccessKeyId())
                .setAccessKeySecret(properties.getAccessKeySecret())
                .setEndpoint(properties.getEndpoint());

        try {
            return new Client(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
