package cn.edu.seig.smartcode.common.exception;

import cn.edu.seig.smartcode.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * ClassName: SmartCodeException
 * Package: cn.edu.seig.smartcode.common.exception
 * Description:
 *  异常包装类
 * @Author 阿小健
 * @Create 2024/11/16 14:00
 * @Version 1.0
 */
@Data
public class SmartCodeException extends RuntimeException{
    private Integer code;

    public SmartCodeException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    public SmartCodeException(Integer code,String message) {
        super(message);
        this.code = code;
    }

}
