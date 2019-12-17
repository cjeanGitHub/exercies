/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AppleTest
 * Author:   14172
 * Date:     2019/12/16 16:41
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.daliytest.annotation;

/**
 * @author 14172
 * @create 2019/12/16
 * @since 1.0.0
 */
public class AppleTest {
    public static void main(String[] args) {
        FruitUntil.getFruitInfo(Apple.class);
        FruitUntil.getFruitInfo(Apple2.class);
    }
}
