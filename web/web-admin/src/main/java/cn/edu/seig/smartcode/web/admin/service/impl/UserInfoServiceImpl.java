package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.UserInfo;
import cn.edu.seig.smartcode.web.admin.mapper.UserInfoMapper;
import cn.edu.seig.smartcode.web.admin.service.UserInfoService;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import cn.edu.seig.smartcode.web.admin.vo.page.UserPageQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.report.UserOverview;
import cn.edu.seig.smartcode.web.admin.vo.report.UserReportVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
* @author 86135
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:27
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

    @Override
    public PageResultVo getPage(UserPageQueryVo queryVo) {
        Page<UserInfo> page = new Page<>(queryVo.getPage(), queryVo.getPageSize());
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(
                StringUtils.isNotBlank(queryVo.getNickname()), UserInfo::getNickname,queryVo.getNickname())
                .like(StringUtils.isNotBlank(queryVo.getPhone()), UserInfo::getPhone,queryVo.getPhone())
                .gt(queryVo.getBeginTime() != null,UserInfo::getCreateTime,queryVo.getBeginTime())
                .eq(queryVo.getStatus() != null, UserInfo::getStatus,queryVo.getStatus())
                .lt(queryVo.getEndTime() != null,UserInfo::getCreateTime,queryVo.getEndTime());
        page(page,wrapper);
        long total = page.getTotal();
        List<UserInfo> records = page.getRecords();
        return PageResultVo.builder().records(records).total(total).build();
    }

    @Override
    public UserOverview getUserOverview(LocalDate today) {
        LambdaQueryWrapper<UserInfo> todayWrapper = new LambdaQueryWrapper<>();
        LocalDateTime todayLast = LocalDateTime.of(today, LocalTime.MAX);
        LocalDateTime todayEearly = LocalDateTime.of(today, LocalTime.MIN);
        todayWrapper.le(UserInfo::getCreateTime, todayLast).ge(UserInfo::getCreateTime, todayEearly);
        Long todayCount = count(todayWrapper);

        LambdaQueryWrapper<UserInfo> yesterdayWrapper = new LambdaQueryWrapper<>();
        LocalDate yesterday = today.plusDays(-1);
        LocalDateTime yesterdayLast = LocalDateTime.of(yesterday, LocalTime.MAX);
        LocalDateTime yesterdayEearly = LocalDateTime.of(yesterday, LocalTime.MIN);
        yesterdayWrapper.le(UserInfo::getCreateTime,yesterdayLast).ge(UserInfo::getCreateTime,yesterdayEearly);
        Long yesterdayCount = count(yesterdayWrapper);

        LambdaQueryWrapper<UserInfo> thisMonthWrapper = new LambdaQueryWrapper<>();
        LocalDate month = today.plusDays(-30);
        LocalDateTime monthLast = LocalDateTime.of(today, LocalTime.MAX);
        LocalDateTime monthEearly = LocalDateTime.of(month, LocalTime.MIN);
        thisMonthWrapper.le(UserInfo::getCreateTime,monthLast).ge(UserInfo::getCreateTime,monthEearly);
        long monthCount = count(thisMonthWrapper);

        Long allCount = count();

        return UserOverview.builder().allCount(allCount).todayCount(todayCount).yesterdayCount(yesterdayCount).thisMonthCount(monthCount).build();

    }

    @Override
    public UserReportVo getUserReportVo(LocalDate begin, LocalDate end) {
        ArrayList<LocalDate> dateList = new ArrayList<>();
        ArrayList<Long> newUserList = new ArrayList<>();
        ArrayList<Long> totalUserList = new ArrayList<>();

        dateList.add(begin);
        while (!begin.equals(end)) {
            begin = begin.plusDays(1);
            dateList.add(begin);
        }

        String dateListStr = StringUtils.join(dateList, ",");

        dateList.forEach(date ->{
            LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);
            LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
            wrapper.ge(UserInfo::getCreateTime, beginTime).le(UserInfo::getCreateTime,endTime);
            Long count = count(wrapper);
            newUserList.add(count);

            wrapper = new LambdaQueryWrapper<UserInfo>();
            wrapper.le(UserInfo::getCreateTime, endTime);
            Long allCount = count(wrapper);
            totalUserList.add(allCount);
        });
        String totalListStr = StringUtils.join(totalUserList, ",");
        String newsListStr = StringUtils.join(newUserList, ",");
        return UserReportVo.builder().dateList(dateListStr).newUserList(newsListStr).totalUserList(totalListStr).build();

    }
}




