package cn.edu.seig.smartcode.common.exception;

import cn.edu.seig.smartcode.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: cn.edu.seig.smartcode.common.exception
 * Description:
 *      全局异常处理器
 *
 * @Author 阿小健
 * @Create 2024/11/16 14:09
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SmartCodeException.class)
    public Result handleSmartCodeException(SmartCodeException e) {
        e.printStackTrace();
        return Result.fail(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }
}
