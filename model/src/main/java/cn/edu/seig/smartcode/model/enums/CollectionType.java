package cn.edu.seig.smartcode.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ClassName: CollectionType
 * Package: cn.edu.seig.smartcode.model.enums
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 10:03
 * @Version 1.0
 */
public enum CollectionType implements BaseEnum{
    COMMUNICATION(1,"文章收藏"),
    LESSON(2,"课程收藏"),
    RESOURCE(3,"资料收藏");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    CollectionType(Integer code, String name) {
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
