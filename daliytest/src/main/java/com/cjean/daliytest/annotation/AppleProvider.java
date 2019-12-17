/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: AppleProvider
 * Author:   14172
 * Date:     2019/12/16 16:23
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.cjean.daliytest.annotation;

import java.lang.annotation.*;

/**
 * @author 14172
 * @create 2019/12/16
 * @since 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AppleProvider {
    public String name() default "xiaohua";

    public String address() default "hanzghou";
}
