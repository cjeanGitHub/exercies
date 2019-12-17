/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: FruitUntil
 * Author:   14172
 * Date:     2019/12/16 16:32
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
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
        String info = "������Ϣ";
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(AppleProvider.class)){
                AppleProvider appleProvider = (AppleProvider) declaredField.getAnnotation(AppleProvider.class);
                info = "===��������:"+appleProvider.name()+ ";������ַ:"+appleProvider.address();

                System.out.println(info);

            }
        }


    }
}
