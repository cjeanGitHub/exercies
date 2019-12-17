/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FruitUntil
 * Author:   14172
 * Date:     2019/12/16 16:32
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.daliytest.annotation;

import java.lang.reflect.Field;

/**
 * @author 14172
 * @create 2019/12/16
 * @since 1.0.0
 */
public class FruitUntil {
    public static void  getFruitInfo(Class clazz){
        Field[] declaredFields = clazz.getDeclaredFields();
        String info = "供货信息";
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(AppleProvider.class)){
                AppleProvider appleProvider = (AppleProvider) declaredField.getAnnotation(AppleProvider.class);
                info = "===供货姓名:"+appleProvider.name()+ ";供货地址:"+appleProvider.address();

                System.out.println(info);

            }
        }


    }
}
