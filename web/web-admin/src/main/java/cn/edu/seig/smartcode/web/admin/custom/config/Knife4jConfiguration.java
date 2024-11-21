package cn.edu.seig.smartcode.web.admin.custom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: Knife4jConfiguration
 * Package: cn.edu.seig.smartcode.web.admin.custom.config
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 22:31
 * @Version 1.0
 */
@Configuration
public class Knife4jConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("后台管理")
                        .version("1.0")
                        .description("后台管理接口")
                        .termsOfService("http://doc.xiaominfo.com")
                        .license(new License().name("Apache 2.0")
                                .url("http://doc.xiaominfo.com")));
    }


    @Bean
    public GroupedOpenApi loginAPI() {
        return GroupedOpenApi.builder().group("登录信息管理").
                pathsToMatch("/admin/login/**","/admin/info").
                build();
    }

    @Bean
    public GroupedOpenApi fileUploadAPI() {
        return GroupedOpenApi.builder().group("文件上传管理").
                pathsToMatch(
                        "/admin/file/upload").
                build();
    }

    @Bean
    public GroupedOpenApi ResourceAPI() {
        return GroupedOpenApi.builder().group("资料管理").
                pathsToMatch(
                        "/admin/resource/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi AdminUserAPI() {
        return GroupedOpenApi.builder().group("后台用户管理").
                pathsToMatch(
                        "/admin/systemAdmin/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi userAPI() {
        return GroupedOpenApi.builder().group("小程序端用户管理").
                pathsToMatch(
                        "/admin/wxuser/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi lessonAPI() {
        return GroupedOpenApi.builder().group("课程管理").
                pathsToMatch(
                        "/admin/lesson/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi communicationAPI() {
        return GroupedOpenApi.builder().group("社区交流管理").
                pathsToMatch(
                        "/admin/communication/**"
                ).
                build();
    }



    @Bean
    public GroupedOpenApi caseAnalysisAPI() {
        return GroupedOpenApi.builder().group("案例分析管理").
                pathsToMatch(
                        "/admin/analysis/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi studyWayAPI() {
        return GroupedOpenApi.builder().group("学习路线管理").
                pathsToMatch(
                        "/admin/studyway/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi reportAPI() {
        return GroupedOpenApi.builder().group("数据统计相关").
                pathsToMatch(
                        "/admin/report/**"
                ).
                build();
    }

    @Bean
    public GroupedOpenApi carouselAPI() {
        return GroupedOpenApi.builder().group("轮播图管理").
                pathsToMatch(
                        "/admin/carousel/**"
                ).
                build();
    }
}
