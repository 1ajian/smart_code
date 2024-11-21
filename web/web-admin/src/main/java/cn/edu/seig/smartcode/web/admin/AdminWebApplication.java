package cn.edu.seig.smartcode.web.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: AdminWebApplication
 * Package: cn.edu.seig.smartcode.web.admin
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 16:23
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("cn.edu.seig.smartcode")
@MapperScan("cn.edu.seig.smartcode.web.admin.mapper")
public class AdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminWebApplication.class, args);
    }
}
