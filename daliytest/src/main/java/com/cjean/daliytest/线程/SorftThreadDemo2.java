package com.cjean.daliytest.�߳�;

import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName:SorftThreadDemo
 * @Description: ʹ�߳�����ִ��
 * <p>
 * ����������Ҫ�������һ��Ӧ�ó�����
 * <p>
 * 1.���ϣ�2.������Ա����Ʒ����������Ա½��������˾�ϰࣻ3.��Ʒ����滮������4.������Ա�����������ܣ�5.������Ա�����¹��ܡ�
 * <p>
 * �滮���󣬿��������¹��ܣ������¹�����һ����˳��ģ����ǰ�thread1������Ʒ����thread2����������Ա��thread3����������Ա��
 * @author: chu_c
 * @date: 2019-11-04
 */

public class SorftThreadDemo2 {

    //���� �๦����
    private static ReentrantLock lock = new ReentrantLock();
    //����2������������
    /**
     * @author wwj
     * ʹ��Condition(��������)ʵ���̰߳�˳������
     */
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();


    private static Object myLock1 = new Object();
    private static Object myLock2 = new Object();

    /**
     * ΪʲôҪ����������ʶ״̬?
     * ���û��״̬��ʶ����t1�Ѿ���������t2�����У�t2�ڵȴ�t1���ѵ���t2��Զ���ڵȴ�״̬
     */
    private static Boolean t1Run = false;
    private static Boolean t2Run = false;

    private static ExecutorService es = Executors.newFixedThreadPool(1);

    //����2������������  ʹ��countdown�������ﵽ������һ��Ч�� ʹ�� wait�����ȴ�����������Ϊ0��ʱ��
    private static CountDownLatch latch1 = new CountDownLatch(1);
    private static CountDownLatch latch2 = new CountDownLatch(1);

    //��Ϊ��3������  ÿ��ִ��2���ﵽ˳��ִ�е�Ч��   ÿһ��await�൱������һ������  �ػ�դ������
    private static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);//��2����  �Ϳ����ͷ�դ����
    private static CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);//��2����  �Ϳ����ͷ�դ����

    /**
     * @author wwj
     * ʹ��Sephmore(�ź���)ʵ���̰߳�˳������
     */
    //ͨ��ʹ��sqmaphore ��release���� �ͷ�һ�����֤���ź�  �̼�ͨ��aquire���� ȥ����һ�����֤�����ź�
    private static Semaphore semaphore1 = new Semaphore(1);//ֻ��һ������ź�
    private static Semaphore semaphore2 = new Semaphore(1);//ֻ��һ������ź�



    public static void main(String[] args) {
        ThreadSemaphoreDemo();

//ʹ�� CyclicBarrier (�ػ�դ��)ʵ���̰߳�˳��ִ��
//        ThreadCylicBarrierDemo();
//ʹ���̵߳� CuDownLatch(������) ����
//        ThreadCountDownLatchDemo();
//ʹ���̵߳� Condition(��������) ����
//        ThreadConditionDemo();
//ʹ���̵߳��̳߳ط���---01
//        ThreadPoolDemo();
        //ʹ���̵߳� wait ����
//        ThreadWaitDemo();
        //ͨ��������joinʹ�̰߳�˳��ִ��
//        ThreadMainJoinDemo();
        //ʹ���̵߳� join ����
//        ThreadJoinDemo();

    }

    /***
    * @Description:
     * Sephmore(�ź���):Semaphore��һ�������ź���,�Ӹ����Ͻ���Semaphore����һ�����֤,�������Ҫ�Ļ���ÿ��acquire()��������������
     * ֱ����ȡһ�����õ����֤,ÿ��release()���������ͷų������֤���̣߳����ҹ黹Semaphoreһ�����õ����֤��
     * Ȼ����ʵ���ϲ�û����ʵ�����֤�����߳�ʹ�ã�Semaphoreֻ�ǶԿ��õ��������й���ά����
     *
     * acquire():��ǰ�̳߳���ȥ�����Ļ�ȡ1�����֤,�˹�����������,��ǰ�̻߳�ȡ��1�����õ����֤�����ֹͣ�ȴ�������ִ�С�
     *
     * release():��ǰ�߳��ͷ�1�����õ����֤��
     *
     * Ӧ�ó���:Semaphore���������������������ر��ǶԹ�����Դ���޵ĳ������������ݿ����ӡ���������������󣬶�ȡ������ļ������ݵ����ݿ��У�
     * �����ļ���ȡ��IO�ܼ������񣬿���������ʮ���̲߳�����ȡ���������ݿ�������ֻ��10������ʱ�ͱ���������ֻ��10���߳��ܹ��õ����ݿ����ӽ��в��������ʱ�򣬾Ϳ���ʹ��Semaphore���������ơ�
    * @param: []
    * @return: void
    * @author: chu_c
    * @date: 2019-11-07
    */
    private static void ThreadSemaphoreDemo(){
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ʒ����滮������");
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
                System.out.println("������Ա������������");
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
                    System.out.println("������Ա�����¹���");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        thread3.start();
        System.out.println("��Ʒ�������ϰ���...");
        thread1.start();
        System.out.println("������Ա���ϰ���...");
        thread2.start();

    }

    /***
     * @Description:
     * CyclicBarrier(�ػ�դ��):ͨ��������ʵ����һ���̵߳ȴ���ĳ��״̬֮����ȫ��ͬʱִ�С������ػ�����Ϊ�����еȴ��̶߳����ͷ��Ժ�CyclicBarrier
     * ���Ա����á��������Ұ����״̬�ͽ���barrier��������await()����֮���߳̾ʹ���barrier�ˡ�
     *
     * Ӧ�ó���:��˾��֯����,�ȴ����е�Ա�����Ｏ�ϵص���ܳ�����ÿ���˵�������barrier״̬��������󣬻�����һ�����ȥ����
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadCylicBarrierDemo() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ʒ����滮������");
                try {
                    cyclicBarrier1.await();//+1    //�ſ�դ��==1
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
                    //�ſ�դ��==1  +1
                    cyclicBarrier1.await();
                    System.out.println("������Ա������������");
                    //�ſ�դ��==2  +1
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
                    //�ſ�դ��==2  +1
                    cyclicBarrier2.await();
                    System.out.println("������Ա�����¹���");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        thread3.start();
        System.out.println("��Ʒ�������ϰ���...");
        thread1.start();
        System.out.println("������Ա���ϰ���...");
        thread2.start();
    }

    /***
     * @Description:
     * CountDownLatch:λ��java.util.concurrent���£�����������ʵ�����Ƽ������Ĺ��ܡ�
     *
     * Ӧ�ó���:������һ������C����Ҫ�ȴ���������A,Bִ�����֮�����ִ�У���ʱ�Ϳ�������CountDownLatch��ʵ�����ֹ����ˡ�
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadCountDownLatchDemo() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ʒ����滮������");
                //��c1����ʱ-1
                latch1.countDown();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //�ȴ�c1����ʱ����ʱΪ0����������
                try {
                    latch1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("������Ա������������");
                //��c2����ʱ-1
                latch2.countDown();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //�ȴ�c2����ʱ����ʱΪ0����������
                try {
                    latch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("������Ա�����¹���");
            }
        });
        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        thread3.start();
        System.out.println("��Ʒ�������ϰ���...");
        thread1.start();
        System.out.println("������Ա���ϰ���...");
        thread2.start();
    }

    /***
     * @Description: Condition������������:ͨ����һ������������Ҫ�ڶ��Contidion�й���һ����ʱ�����Դ���һ��Lock/RLockʵ�������췽�������������Լ�����һ��RLockʵ����

    Condition��await()����������Object���е�wait()������
    Condition��await(long time,TimeUnit unit)����������Object���е�wait(long time)������
    Condition��signal()����������Object���е�notify()������
    Condition��signalAll()����������Object���е�notifyAll()������
    Ӧ�ó�����Condition��һ�����̼߳�Э��ͨ�ŵĹ����࣬ʹ��ĳ��������ĳЩ�߳�һ��ȴ�ĳ��������Condition��,ֻ�е��������߱�( signal
    ���� signalAll����������)ʱ ����Щ�ȴ��̲߳Żᱻ���ѣ��Ӷ�������������
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
                System.out.println("��Ʒ����滮������...");
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
                        System.out.println("������Ա����Ϣ��...");
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("������Ա������������");
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
                        System.out.println("������Ա����Ϣ��...");
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("������Ա�����¹���");
                }
                lock.unlock();
            }
        });
        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        thread3.start();
        System.out.println("��Ʒ�������ϰ���...");
        thread1.start();
        System.out.println("������Ա���ϰ���...");
        thread2.start();
    }

    /***
     * @Description:
     * JAVAͨ��Executors�ṩ�������̳߳�
     *
     * ���̻߳��̳߳�(newSingleThreadExecutor);
     * �ɿ���󲢷����̳߳�(newFixedThreadPool);
     * �ɻ��ջ����̳߳�(newCachedThreadPool);
     * ֧�ֶ�ʱ��������������̳߳�(newScheduledThreadPool)��
     * ���̻߳��̳߳�(newSingleThreadExecutor):�ŵ㣬����ִ����������
     *
     * submit()���ύ����
     *
     * shutdown()�����������ر��̳߳أ��ܾ�������
     *
     * Ӧ�ó���:����ִ����������������Ψһ���߳���Ϊ�쳣��������ô����һ���µ��߳�������������̳߳ر�֤���������ִ��˳����������ύ˳��ִ�С�
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadPoolDemo() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ʒ����滮������");
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("������Ա������������");
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("������Ա�����¹���");
            }
        });
        final Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ŀ������...");
            }
        });
        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        System.out.println("��Ʒ�������ϰ���...");
        System.out.println("������Ա���ϰ���...");

        es.submit(thread1);
        es.submit(thread2);
        es.submit(thread3);
        es.submit(thread4);
        es.shutdown();
//        if (!es.isShutdown()) {
//            System.out.println("��û������...isTerminated");
//        }else {
//            System.out.println("��Ŀ������...isTerminated");
//        };
    }


    /***
     * @Description:
     * wait():��Object�ķ������������õ�ǰ�߳̽���ȴ�״̬��ͬʱ��wait()Ҳ���õ�ǰ�߳��ͷ��������е�������ֱ�������̵߳��ô˶����
     * notify() ������ notifyAll() ����������ǰ�̱߳�����(���롰����״̬��)
     *
     * notify()��notifyAll():��Object�ķ������������ǻ��ѵ�ǰ�����ϵĵȴ��̣߳�notify()�ǻ��ѵ����̣߳���notifyAll()�ǻ������е��̡߳�
     *
     * wait(long timeout):�õ�ǰ�̴߳��ڡ��ȴ�(����)״̬������ֱ�������̵߳��ô˶����notify()������ notifyAll() ������
     * ���߳���ָ����ʱ����������ǰ�̱߳�����(���롰����״̬��)��
     *
     * Ӧ�ó�����Javaʵ�������������ߵķ�ʽ��
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
                    System.out.println("��Ʒ����滮������...");
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
                            System.out.println("������Ա����Ϣ��...");
                            myLock1.wait();
                        }
                        synchronized (myLock2) {
                            System.out.println("������Ա������������");
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
                            System.out.println("������Ա����Ϣ��...");
                            myLock2.wait();
                        }
                        System.out.println("������Ա�����¹���");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        thread3.start();
        System.out.println("��Ʒ�������ϰ���...");
        thread1.start();
        System.out.println("������Ա���ϰ���...");
        thread2.start();
    }

    /**
     * @author wwj
     * ͨ��������joinʹ�̰߳�˳��ִ��
     */
    private static void ThreadMainJoinDemo() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ʒ����滮������");
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("������Ա������������");
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("������Ա�����¹���");
            }
        });
        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        System.out.println("��Ʒ�������ϰ���...");
        System.out.println("������Ա���ϰ���...");

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
     * ʹ���̵߳� join ����
     *
     * join():��Theard�ķ����������ǵ����߳���ȴ���join()�߳�ִ����ɺ󣬲��ܼ����������С�
     *
     * Ӧ�ó���:��һ���̱߳���ȴ���һ���߳�ִ����ϲ���ִ��ʱ����ʹ��join������
     * @param:
     * @return:
     * @author: chu_c
     * @date: 2019-11-07
     */
    private static void ThreadJoinDemo() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ʒ����滮������");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println("������Ա������������");
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
                    System.out.println("������Ա�����¹���");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        thread3.start();
        System.out.println("��Ʒ�������ϰ���...");
        thread1.start();
        System.out.println("������Ա���ϰ���...");
        thread2.start();
    }


}

