package cn.edu.seig.smartcode.web.admin.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.media.DateSchema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: ResourceTypeVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/18 21:46
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "资料类型Vo")
public class ResourceTypeVo extends PageQueryVo{

    @Schema(description = "资料类型名称")
    private String typeName;

    @Schema(description = "资料具体类型名称")
    private String resourceName;
}
