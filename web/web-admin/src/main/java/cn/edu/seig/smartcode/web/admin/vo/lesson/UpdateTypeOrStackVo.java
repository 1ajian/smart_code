package cn.edu.seig.smartcode.web.admin.vo.lesson;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.runtime.Desc;

import javax.print.attribute.standard.PrinterURI;

/**
 * ClassName: UpdateTypeOrStackVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.lesson
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/19 21:58
 * @Version 1.0
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "更新课程类型和技术栈Vo")
public class UpdateTypeOrStackVo {
    @Schema(description = "老课程类型Id")
    private Long oldTypeId;

    @Schema(description = "老技术栈id")
    private Long oldStackId;

    @Schema(description = "新课程类型id")
    private Long newTypeId;

    @Schema(description = "新技术栈id")
    private Long newStackId;



}
