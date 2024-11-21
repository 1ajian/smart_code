package cn.edu.seig.smartcode.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ClassName: CommentType
 * Package: cn.edu.seig.smartcode.model.enums
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 21:57
 * @Version 1.0
 */
public enum CommentArticleType implements BaseEnum{
    COMMONTYPE(0,"普通交流类型"),
    CASEANALYSIS(1,"案例分析");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    CommentArticleType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
