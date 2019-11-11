package com.cjean.daliytest.线程;

import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName:SorftThreadDemo
 * @Description: 使线程有序执行
 * <p>
 * 我们下面需要完成这样一个应用场景：
 * <p>
 * 1.早上；2.测试人员、产品经理、开发人员陆续的来公司上班；3.产品经理规划新需求；4.开发人员开发新需求功能；5.测试人员测试新功能。
 * <p>
 * 规划需求，开发需求新功能，测试新功能是一个有顺序的，我们把thread1看做产品经理，thread2看做开发人员，thread3看做测试人员。
 * @author: chu_c
 * @date: 2019-11-04
 */

public class SorftThreadDemo2 {

    //创建 多功能锁
    private static ReentrantLock lock = new ReentrantLock();
    //创建2个锁条件环境
    /**
     * @author wwj
     * 使用Condition(条件变量)实现线程按顺序运行
     */
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();


    private static Object myLock1 = new Object();
    private static Object myLock2 = new Object();

    /**
     * 为什么要加这两个标识状态?
     * 如果没有状态标识，当t1已经运行完了t2才运行，t2在等待t1唤醒导致t2永远处于等待状态
     */
    private static Boolean t1Run = false;
    private static Boolean t2Run = false;

    private static ExecutorService es = Executors.newFixedThreadPool(1);

    //创建2个倒数计数器  使用countdown方法来达到计数减一的效果 使用 wait方法等待计数器计数为0的时候
    private static CountDownLatch latch1 = new CountDownLatch(1);
    private static CountDownLatch latch2 = new CountDownLatch(1);

    //因为是3个对象  每次执行2个达到顺序执行的效果   每一次await相当于满足一次条件  回环栅栏工具
    private static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);//有2个了  就可以释放栅栏了
    private static CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);//有2个了  就可以释放栅栏了

    /**
     * @author wwj
     * 使用Sephmore(信号量)实现线程按顺序运行
     */
    //通过使用sqmaphore 的release方法 释放一个许可证书信号  商家通过aquire方法 去申请一个许可证书新信号
    private static Semaphore semaphore1 = new Semaphore(1);//只给一个许可信号
    private static Semaphore semaphore2 = new Semaphore(1);//只给一个许可信号



    public static void main(String[] args) {
        ThreadSemaphoreDemo();

//使用 CyclicBarrier (回环栅栏)实现线程按顺序执行
//        ThreadCylicBarrierDemo();
//使用线程的 CuDownLatch(倒计数) 方法
//        ThreadCountDownLatchDemo();
//使用线程的 Condition(条件变量) 方法
//        ThreadConditionDemo();
//使用线程的线程池方法---01
//        ThreadPoolDemo();
        //使用线程的 wait 方法
//        ThreadWaitDemo();
        //通过主程序join使线程按顺序执行
//        ThreadMainJoinDemo();
        //使用线程的 join 方法
//        ThreadJoinDemo();

    }

    /***
    * @Description:
     * Sephmore(信号量):Semaphore是一个计数信号量,从概念上将，Semaphore包含一组许可证,如果有需要的话，每个acquire()方法都会阻塞，
     * 直到获取一个可用的许可证,每个release()方法都会释放持有许可证的线程，并且归还Semaphore一个可用的许可证。
     * 然而，实际上并没有真实的许可证对象供线程使用，Semaphore只是对可用的数量进行管理维护。
     *
     * acquire():当前线程尝试去阻塞的获取1个许可证,此过程是阻塞的,当前线程获取了1个可用的许可证，则会停止等待，继续执行。
     *
     * release():当前线程释放1个可用的许可证。
     *
     * 应用场景:Semaphore可以用来做流量分流，特别是对公共资源有限的场景，比如数据库连接。假设有这个的需求，读取几万个文件的数据到数据库中，
     * 由于文件读取是IO密集型任务，可以启动几十个线程并发读取，但是数据库连接数只有10个，这时就必须控制最多只有10个线程能够拿到数据库连接进行操作。这个时候，就可以使用Semaphore做流量控制。
    * @param: []
    * @return: void
    * @author: chu_c
    * @date: 2019-11-07
    */
    private static void ThreadSemaphoreDemo(){
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
                semaphore1.release(1);
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    semaphore1.acquire(1);
                    semaphore1.tryAcquire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("开发人员开发新需求功能");
                semaphore2.release(1);
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    semaphore2.acquire(1);
                    semaphore2.tryAcquire();
                    thread2.join();
                    System.out.println("测试人员测试新功能");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();

    }

    /***
     * @Description:
     * CyclicBarrier(回环栅栏):通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier
     * 可以被重用。我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
     *
     * 应用场景:公司组织春游,等待所有的员工到达集合地点才能出发，每个人到达后进入barrier状态。都到达后，唤起大家一起出发去旅行
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadCylicBarrierDemo() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
                try {
                    cyclicBarrier1.await();//+1    //放开栅栏==1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //放开栅栏==1  +1
                    cyclicBarrier1.await();
                    System.out.println("开发人员开发新需求功能");
                    //放开栅栏==2  +1
                    cyclicBarrier2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //放开栅栏==2  +1
                    cyclicBarrier2.await();
                    System.out.println("测试人员测试新功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
    }

    /***
     * @Description:
     * CountDownLatch:位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
     *
     * 应用场景:比如有一个任务C，它要等待其他任务A,B执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadCountDownLatchDemo() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
                //对c1倒计时-1
                latch1.countDown();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //等待c1倒计时，计时为0则往下运行
                try {
                    latch1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开发人员开发新需求功能");
                //对c2倒计时-1
                latch2.countDown();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //等待c2倒计时，计时为0则往下运行
                try {
                    latch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("测试人员测试新功能");
            }
        });
        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
    }

    /***
     * @Description: Condition（条件变量）:通常与一个锁关联。需要在多个Contidion中共享一个锁时，可以传递一个Lock/RLock实例给构造方法，否则它将自己生成一个RLock实例。

    Condition中await()方法类似于Object类中的wait()方法。
    Condition中await(long time,TimeUnit unit)方法类似于Object类中的wait(long time)方法。
    Condition中signal()方法类似于Object类中的notify()方法。
    Condition中signalAll()方法类似于Object类中的notifyAll()方法。
    应用场景：Condition是一个多线程间协调通信的工具类，使得某个，或者某些线程一起等待某个条件（Condition）,只有当该条件具备( signal
    或者 signalAll方法被调用)时 ，这些等待线程才会被唤醒，从而重新争夺锁。
     * @param:
     * @return:
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadConditionDemo() {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("产品经理规划新需求...");
                condition1.signal();
                t1Run = true;
                lock.unlock();
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                if (!t1Run) {
                    try {
                        System.out.println("开发人员先休息会...");
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("开发人员开发新需求功能");
                condition2.signal();
                t2Run = true;

                lock.unlock();
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                if (!t2Run) {
                    try {
                        System.out.println("测试人员先休息会...");
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("测试人员测试新功能");
                }
                lock.unlock();
            }
        });
        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
    }

    /***
     * @Description:
     * JAVA通过Executors提供了四种线程池
     *
     * 单线程化线程池(newSingleThreadExecutor);
     * 可控最大并发数线程池(newFixedThreadPool);
     * 可回收缓存线程池(newCachedThreadPool);
     * 支持定时与周期性任务的线程池(newScheduledThreadPool)。
     * 单线程化线程池(newSingleThreadExecutor):优点，串行执行所有任务。
     *
     * submit()：提交任务。
     *
     * shutdown()：方法用来关闭线程池，拒绝新任务。
     *
     * 应用场景:串行执行所有任务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadPoolDemo() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开发人员开发新需求功能");
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试人员测试新功能");
            }
        });
        final Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("项目交付了...");
            }
        });
        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        System.out.println("产品经理来上班了...");
        System.out.println("开发人员来上班了...");

        es.submit(thread1);
        es.submit(thread2);
        es.submit(thread3);
        es.submit(thread4);
        es.shutdown();
//        if (!es.isShutdown()) {
//            System.out.println("还没交付了...isTerminated");
//        }else {
//            System.out.println("项目交付了...isTerminated");
//        };
    }


    /***
     * @Description:
     * wait():是Object的方法，作用是让当前线程进入等待状态，同时，wait()也会让当前线程释放它所持有的锁。“直到其他线程调用此对象的
     * notify() 方法或 notifyAll() 方法”，当前线程被唤醒(进入“就绪状态”)
     *
     * notify()和notifyAll():是Object的方法，作用则是唤醒当前对象上的等待线程；notify()是唤醒单个线程，而notifyAll()是唤醒所有的线程。
     *
     * wait(long timeout):让当前线程处于“等待(阻塞)状态”，“直到其他线程调用此对象的notify()方法或 notifyAll() 方法，
     * 或者超过指定的时间量”，当前线程被唤醒(进入“就绪状态”)。
     *
     * 应用场景：Java实现生产者消费者的方式。
     * @param:
     * @return:
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadWaitDemo() {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock1) {
                    System.out.println("产品经理规划新需求...");
                    myLock1.notify();
                    t1Run = true;
                }
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock1) {
                    try {
                        if (!t1Run) {
                            System.out.println("开发人员先休息会...");
                            myLock1.wait();
                        }
                        synchronized (myLock2) {
                            System.out.println("开发人员开发新需求功能");
                            myLock2.notify();
                            t2Run = true;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock2) {
                    try {
                        if (!t2Run) {
                            System.out.println("测试人员先休息会...");
                            myLock2.wait();
                        }
                        System.out.println("测试人员测试新功能");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
    }

    /**
     * @author wwj
     * 通过主程序join使线程按顺序执行
     */
    private static void ThreadMainJoinDemo() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开发人员开发新需求功能");
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试人员测试新功能");
            }
        });
        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        System.out.println("产品经理来上班了...");
        System.out.println("开发人员来上班了...");

        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /***
     * @Description:
     * 使用线程的 join 方法
     *
     * join():是Theard的方法，作用是调用线程需等待该join()线程执行完成后，才能继续用下运行。
     *
     * 应用场景:当一个线程必须等待另一个线程执行完毕才能执行时可以使用join方法。
     * @param:
     * @return:
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadJoinDemo() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println("开发人员开发新需求功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    System.out.println("测试人员测试新功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
    }


}

