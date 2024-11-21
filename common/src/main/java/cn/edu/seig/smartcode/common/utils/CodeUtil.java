package cn.edu.seig.smartcode.common.utils;

import java.util.Random;

/**
 * ClassName: CodeUtil
 * Package: cn.edu.seig.smartcode.common.utils
 * Description:
 *
 * @Author 阿小健
 * @Create 2024/11/16 14:57
 * @Version 1.0
 */
public class CodeUtil {

    public static String getRandomCode(Integer length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(10);
            stringBuilder.append(number);
        }

        return stringBuilder.toString();
    }
}