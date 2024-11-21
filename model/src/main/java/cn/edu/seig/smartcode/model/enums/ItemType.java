package cn.edu.seig.smartcode.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ClassName: ItemType
 * Package: cn.edu.seig.smartcode.model.enums
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 22:24
 * @Version 1.0
 */
public enum ItemType implements BaseEnum{

    LESSONTYPE(1,"课程类型"),
    RESOURCETYPE(4,"资料类型"),
    COMMUNICATION(2,"普通交流表类型"),
    CASEANALYSIS(3,"案例分析类型");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    ItemType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
