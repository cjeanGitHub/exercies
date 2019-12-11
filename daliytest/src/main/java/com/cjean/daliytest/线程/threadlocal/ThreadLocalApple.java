package com.cjean.daliytest.线程.threadlocal;

/**
 * @ClassName:ThreadApple
 * @Description:
 * @author: chu_c
 * @date: 2019-11-11
 */

public class ThreadLocalApple {

    private int appleId = 1;
    public int shareid = 2;

    private int appleId1 = 3;

    public int shareid1 = 4;



    public ThreadLocalApple(int appleId) {
        this.appleId = appleId;
    }
    public ThreadLocalApple() {

    }
    //私有的 对象构造方法
    private ThreadLocalApple(int appleId,int appleId1) {

    }


    public int getAppleId1() {
        return appleId1;
    }

    public void setAppleId1(int appleId1) {
        this.appleId1 = appleId1;
    }

    public int getShareid1() {
        return shareid1;
    }

    public void setShareid1(int shareid1) {
        this.shareid1 = shareid1;
    }

    public int getAppleId() {
        return appleId;
    }

    public void setAppleId(int appleId) {
        this.appleId = appleId;
    }

    public int getShareid() {
        return shareid;
    }

    public void setShareid(int shareid) {
        this.shareid = shareid;
    }

    //私有的 对象方法
    private void setNoSharedMe(int i){
        this.shareid1 = i;

    }
    //私有的 对象方法
    private int getNoSharedMe(){
        return this.shareid1;
    }
}
