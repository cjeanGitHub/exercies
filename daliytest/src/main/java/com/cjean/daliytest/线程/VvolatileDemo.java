/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: VvolatileDemo
 * Author:   14172
 * Date:     2019/12/6 13:58
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.daliytest.线程;

/**
 * @author 14172
 * @create 2019/12/6
 * @since 1.0.0
 */
public class VvolatileDemo {
    private volatile static int a = 3;

    public static void main(String[] args) {
        System.out.println("VvolatileDemo,main()-1,a:"+a);
        TesVolatile tesVolatile = new TesVolatile(a);
        tesVolatile.incrByVo();

        System.out.println("VvolatileDemo,main()-2,a:"+a);
    }

    public void incr(){
        a++;
        System.out.println("VvolatileDemo,incr(),a:"+a);
    }


}
class TesVolatile {
    private int a;
    public TesVolatile(int a) {
        this.a = a;
    }
    public void incrByVo(){
        VvolatileDemo v = new VvolatileDemo();
        v.incr();
    }

    public void incr(){
        a++;
        System.out.println("TesVolatile,a:"+a);
    }

}
