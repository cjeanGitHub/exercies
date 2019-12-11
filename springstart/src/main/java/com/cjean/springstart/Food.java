/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Food
 * Author:   14172
 * Date:     2019/12/11 10:05
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.springstart;

/**
 * @author 14172
 * @create 2019/12/11
 * @since 1.0.0
 */
public class Food {
    private String apple;
    private String banana;

    public Food(String apple, String banana) {
        this.apple = apple;
        this.banana = banana;
    }
    public Food() {
    }

    public static Food getFoodByStaticFactory(){
        return new Food();
    }

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public String getBanana() {
        return banana;
    }

    public void setBanana(String banana) {
        this.banana = banana;
    }
}
