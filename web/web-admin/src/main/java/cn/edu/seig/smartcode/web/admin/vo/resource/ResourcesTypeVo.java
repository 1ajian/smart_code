package cn.edu.seig.smartcode.web.admin.vo.resource;

import cn.edu.seig.smartcode.model.entity.ResourceDetailType;
import cn.edu.seig.smartcode.model.entity.ResourceType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: ResourceTypeVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.resource
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/21 15:33
 * @Version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "获取资料类型和资料具体类型Vo")
public class ResourcesTypeVo extends ResourceType {

    @Schema(description = "资料具体类型")
    private List<ResourceDetailType> resourceDetailTypeList;
}
