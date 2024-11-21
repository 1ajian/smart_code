package cn.edu.seig.smartcode.web.admin.service;

import cn.edu.seig.smartcode.model.entity.CaseAnalysis;
import cn.edu.seig.smartcode.web.admin.vo.page.PageCaseAnalysisQueryVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86135
* @description 针对表【case_analysis(案例分析表)】的数据库操作Service
* @createDate 2024-11-16 20:35:50
*/
public interface CaseAnalysisService extends IService<CaseAnalysis> {

    /**
     * 分页查询案例分析
     * @param analysisQueryVo
     * @return
     */
    PageResultVo getPage(PageCaseAnalysisQueryVo analysisQueryVo);
}
