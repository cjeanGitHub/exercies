/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: Apple
 * Author:   14172
 * Date:     2019/12/16 16:28
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.cjean.daliytest.annotation;

/**
 * @author 14172
 * @create 2019/12/16
 * @since 1.0.0
 */
public class Apple {
    @AppleProvider(name = "xianzhang",address = "zaozhuang")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
