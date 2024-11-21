package cn.edu.seig.smartcode.web.admin.vo.page;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.runtime.Desc;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ClassName: ResourcePageQueryVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.page
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/17 16:36
 * @Version 1.0
 */
@Schema(description = "资源分页查询条件")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourcePageQueryVo extends PageQueryVo{
    @Schema(description = "资源名称")
    private String name;

    @Schema(description = "上传者Id")
    private Long uploadAdminId;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Schema(description = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @Schema(description = "资源类型Id")
    private Long resourceTypeId;

    @Schema(description = "资源具体类型Id")
    private Long resourceDetailTypeId;

}
