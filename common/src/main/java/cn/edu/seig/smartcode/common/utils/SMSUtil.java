package cn.edu.seig.smartcode.common.utils;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: SMSUtil
 * Package: cn.edu.seig.smartcode.common.utils
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 23:01
 * @Version 1.0
 */
@Component
public class SMSUtil {
    @Autowired
    private Client client;

    public void sendCode(String phone,String code) {
        SendSmsRequest smsRequest = new SendSmsRequest();
        smsRequest.setPhoneNumbers(phone);
        smsRequest.setSignName("阿里云短信测试");
        smsRequest.setTemplateCode("SMS_154950909");
        smsRequest.setTemplateParam("{\"code\":\"" + code + "\"}");
        try {
            client.sendSms(smsRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
