package cn.edu.seig.smartcode.web.admin.service.impl;

import cn.edu.seig.smartcode.model.entity.CaseAnalysis;
import cn.edu.seig.smartcode.web.admin.mapper.CaseAnalysisMapper;
import cn.edu.seig.smartcode.web.admin.service.CaseAnalysisService;
import cn.edu.seig.smartcode.web.admin.vo.caseanalysis.CaseAnalysisVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageCaseAnalysisQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86135
* @description 针对表【case_analysis(案例分析表)】的数据库操作Service实现
* @createDate 2024-11-16 20:40:26
*/
@Service
public class CaseAnalysisServiceImpl extends ServiceImpl<CaseAnalysisMapper, CaseAnalysis>
    implements CaseAnalysisService {

    @Autowired
    private CaseAnalysisMapper caseAnalysisMapper;

    @Override
    public PageResultVo getPage(PageCaseAnalysisQueryVo queryVo) {
        IPage<CaseAnalysisVo> page = new Page<>(queryVo.getPage(),queryVo.getPageSize());
        page = caseAnalysisMapper.page(page,queryVo);
        return PageResultVo.builder().total(page.getTotal()).records(page.getRecords()).build();
    }
}




