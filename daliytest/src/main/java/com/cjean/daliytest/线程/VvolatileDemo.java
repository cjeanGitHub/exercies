/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: VvolatileDemo
 * Author:   14172
 * Date:     2019/12/6 13:58
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.cjean.daliytest.�߳�;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 14172
 * @create 2019/12/6
 * @since 1.0.0
 *  volatile ���������
 * 1.�߳̿ɼ���
 * 2.��ָֹ��������
 *3.���ܱ�֤ԭ���Ե�����
 *
 */
public class VvolatileDemo {
    private volatile static int a = 3;

    public static void main(String[] args) {

        // ���� TesVolatile
//        System.out.println("VvolatileDemo,main()-1,a:"+a);
//        TesVolatile tesVolatile = new TesVolatile(a);
//        tesVolatile.incrByVo();
//
//        System.out.println("VvolatileDemo,main()-2,a:"+a);
    }

    //�ֶ�����1
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
        //����Ӧ����100001 ʮ����һ
        System.out.println("count��"+test01.getCount());
        // 1.     count��81564
        // 1.     count��81949
        // 1.     count��82948

    }

    //�ƽ⼴ʹ��volatile�� �����Լ� ָ����Ȼ�����������
    public void testBreakAutoReSorf(){
        //��������++ -- ����û�н�ָֹ������������⣬�����ʽ�� �ڷ���������synchronized�ؼ���
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
        //����Ӧ����100001 ʮ����һ
        System.out.println("count��"+test01.getCount());
        // 1.     count��100001
        // 1.     count��100001
        // 1.     count��100001
    }


    // �����������Լ�������� �������ݴ������� ����volatile���ܱ�֤ԭ���Ե�����
    public void testAutoBreakVolitle(){
        Test01 test01 = new Test01();
        ArrayList<Thread> threads = new ArrayList<>();
        // test01::autoIncr ����lambud���ʽ  ��˼��ִ��test01��autoIncr����
        for (int i=0;i<10;i++) threads.add(new Thread(test01::autoIncr));

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //����Ӧ����100001 ʮ����һ
        System.out.println("count��"+test01.getCount());
        // 1.     count��79197
        // 1.     count��86799
        // 1.     count��85862
    }

    public void incr(){
        a++;
        System.out.println("VvolatileDemo,incr(),a:"+a);
    }

}

/**
 * ��������: <br>
 * ����
 * ������ ������ �����������
 * �����޷�ʵ�ֽ�ָֹ�����������
 No such property: code for class: Script1
 * @return:
 * @since: 1.0.0
 * @Author:14172
 * @Date: 2019/12/9 9:59
 */

class Test01{
    private volatile int count = 1;
    //�ֶ�����1
    void incr(){
        for (int i = 0; i < 10000; i++)  count = count+1;
    }
    //�Զ�����1
    void autoIncr(){
        for (int i = 0; i < 10000; i++)  count++;
    };
    //�����Զ�����1
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
