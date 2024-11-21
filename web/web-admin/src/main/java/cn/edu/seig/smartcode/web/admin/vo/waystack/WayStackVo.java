package cn.edu.seig.smartcode.web.admin.vo.waystack;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.runtime.Desc;

/**
 * ClassName: WayStack
 * Package: cn.edu.seig.smartcode.web.admin.vo.waystack
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 23:00
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "更新路线中的技术栈条件")
public class WayStackVo {
    @Schema(description = "旧技术栈id")
    private Long oldStackId;
    @Schema(description = "旧学习路线id")
    private Long oldWayId;
    @Schema(description = "新技术栈id")
    private Long newStackId;
    @Schema(description = "新路线id")
    private Long newWayId;
}
