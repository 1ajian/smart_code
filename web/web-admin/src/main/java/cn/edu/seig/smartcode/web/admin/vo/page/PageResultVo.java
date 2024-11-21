package cn.edu.seig.smartcode.web.admin.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: PageResultVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 16:31
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "查询结果封装")
public class PageResultVo implements Serializable {
    private Long total;
    private List records;
}
