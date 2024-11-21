package cn.edu.seig.smartcode.web.admin.custom.converter;

import cn.edu.seig.smartcode.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * ClassName: StringToBaseEnumConverterFactory
 * Package: cn.edu.seig.smartcode.web.admin.custom.config
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 22:36
 * @Version 1.0
 */
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            @Override
            public T convert(String code) {
                T[] enumConstants = targetType.getEnumConstants();
                for (T enumConstant : enumConstants) {
                    if (enumConstant.getCode().toString().equals(code)) {
                        return enumConstant;
                    }
                }
                throw new IllegalArgumentException("code:" + code + "非法");
            }
        };
    }
}
