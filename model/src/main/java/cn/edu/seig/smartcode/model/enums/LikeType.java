package cn.edu.seig.smartcode.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ClassName: LikeType
 * Package: cn.edu.seig.smartcode.model.enums
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/20 9:56
 * @Version 1.0
 */
public enum LikeType implements BaseEnum {
    COMMUNICATIONLIKE(1,"交流文章点赞"),
    LESSONLIKE(2,"课程点赞");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    LikeType(Integer code, String name) {
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
