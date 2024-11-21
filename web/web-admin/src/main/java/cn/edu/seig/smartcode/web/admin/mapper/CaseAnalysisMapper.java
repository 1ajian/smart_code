package cn.edu.seig.smartcode.web.admin.mapper;

import cn.edu.seig.smartcode.model.entity.CaseAnalysis;
import cn.edu.seig.smartcode.web.admin.vo.caseanalysis.CaseAnalysisVo;
import cn.edu.seig.smartcode.web.admin.vo.page.PageCaseAnalysisQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author 86135
* @description 针对表【case_analysis(案例分析表)】的数据库操作Mapper
* @createDate 2024-11-16 20:40:26
* @Entity cn.edu.seig.smartcode.model.entity.CaseAnalysis
*/
public interface CaseAnalysisMapper extends BaseMapper<CaseAnalysis> {

    /**
     * 分页查询案例分析
     * @param page
     * @param queryVo
     * @return
     */
    IPage<CaseAnalysisVo> page(IPage<CaseAnalysisVo> page, PageCaseAnalysisQueryVo queryVo);
}




