package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.UserInfo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.UserPageQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.report.UserOverview;
import cn.edu.seig.smartcode.web.admin.vo.report.UserReportVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;

/**
* @author 86135
* @description 针对表【user_info(用户信息表)】的数据库操作Service
* @createDate 2024-11-16 20:35:51
*/
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 用户分页查询
     * @param userPageQueryVo
     * @return
     */
    PageResultVo getPage(UserPageQueryVo userPageQueryVo);

    /**
     * 用户总览
     * @return
     */
    UserOverview getUserOverview(LocalDate today);

    /**
     *用户人数统计echarts
     * @param begin
     * @param end
     * @return
     */
    UserReportVo getUserReportVo(LocalDate begin, LocalDate end);
}
