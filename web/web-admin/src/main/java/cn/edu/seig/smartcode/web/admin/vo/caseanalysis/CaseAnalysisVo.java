package cn.edu.seig.smartcode.web.admin.vo.caseanalysis;

import cn.edu.seig.smartcode.model.entity.CaseAnalysis;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * ClassName: CaseAnalysisVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.caseanalysis
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 18:45
 * @Version 1.0
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "案例分析返回Vo")
public class CaseAnalysisVo extends CaseAnalysis {

    @Schema(description = "用户昵称")
    private String nickname;
}
