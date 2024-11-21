package cn.edu.seig.smartcode.web.admin.vo.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: UserReportVo
 * Package: cn.edu.seig.smartcode.web.admin.vo.report
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/21 1:45
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReportVo implements Serializable {

    private String dateList;

    private String totalUserList;

    private String newUserList;

}
