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

import java.util.ArrayList;
import java.util.List;

/**
 * @author 14172
 * @create 2019/12/6
 * @since 1.0.0
 *  volatile 解决的问题
 * 1.线程可见性
 * 2.禁止指令重排序
 *3.不能保证原子性的问题
 *
 */
public class VvolatileDemo {
    private volatile static int a = 3;

    public static void main(String[] args) {

        // 测试 TesVolatile
//        System.out.println("VvolatileDemo,main()-1,a:"+a);
//        TesVolatile tesVolatile = new TesVolatile(a);
//        tesVolatile.incrByVo();
//
//        System.out.println("VvolatileDemo,main()-2,a:"+a);
    }

    //手动增加1
    public void testIncrByHangl(){
        Test01 test01 = new Test01();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i=0;i<10;i++) threads.add(new Thread(test01::incr));

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //正常应该是100001 十万零一
        System.out.println("count："+test01.getCount());
        // 1.     count：81564
        // 1.     count：81949
        // 1.     count：82948

    }

    //破解即使在volatile下 自增自减 指令仍然重排序的问题
    public void testBreakAutoReSorf(){
        //这是由于++ -- 自增没有禁止指令重排序的问题，解决方式是 在方法上增加synchronized关键字
        Test01 test01 = new Test01();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i=0;i<10;i++) threads.add(new Thread(test01::autoIncrBySyn));

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //正常应该是100001 十万零一
        System.out.println("count："+test01.getCount());
        // 1.     count：100001
        // 1.     count：100001
        // 1.     count：100001
    }


    // 测试在自增自减的情况下 发生数据错误的情况 由于volatile不能保证原子性的问题
    public void testAutoBreakVolitle(){
        Test01 test01 = new Test01();
        ArrayList<Thread> threads = new ArrayList<>();
        // test01::autoIncr 这是lambud表达式  意思是执行test01的autoIncr方法
        for (int i=0;i<10;i++) threads.add(new Thread(test01::autoIncr));

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //正常应该是100001 十万零一
        System.out.println("count："+test01.getCount());
        // 1.     count：79197
        // 1.     count：86799
        // 1.     count：85862
    }

    public void incr(){
        a++;
        System.out.println("VvolatileDemo,incr(),a:"+a);
    }

}

/**
 * 功能描述: <br>
 * 〈〉
 * 当变量 自增是 发生运算错误
 * 由于无法实现禁止指令重排序造成
 No such property: code for class: Script1
 * @return:
 * @since: 1.0.0
 * @Author:14172
 * @Date: 2019/12/9 9:59
 */

class Test01{
    private volatile int count = 1;
    //手动增加1
    void incr(){
        for (int i = 0; i < 10000; i++)  count = count+1;
    }
    //自动增加1
    void autoIncr(){
        for (int i = 0; i < 10000; i++)  count++;
    };
    //加锁自动增加1
   synchronized void autoIncrBySyn(){
        for (int i = 0; i < 10000; i++)  count++;
    };

    public int getCount() {
        return count;
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
