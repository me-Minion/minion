package com.srs.java.concurrent.callnum;

import org.springframework.util.CollectionUtils;

import java.lang.Object;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shaorensheng
 * @date 2022/1/10
 */
public class TicketDemo extends Thread {

    Queue queue;

    Object lock;

    String serverName;

    public TicketDemo(Queue queue, Object lock, String serverName) {
        this.queue = queue;
        this.lock = lock;
        this.serverName = serverName;
    }

    /**
     * 叫号
     * @return
     */
    public int callNumber() {
        synchronized (Object.class) {
            if (CollectionUtils.isEmpty(queue)) {
                return 0;
            }
            return (int)queue.poll();
        }
    }


    public void deal(int number, int times) {
        System.out.println(serverName + "：" + number);
        //try {
        //    Thread.sleep(new Random().nextInt(10) * 1000L);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        System.out.println(serverName + "结束服务用户：" + number + ".总次数：" + times);
    }


    @Override
    public void run() {
        int times = 1;
        while (true) {
            //叫号
            int number = callNumber();
            if (number == 0) {
                System.out.println(serverName + "增在等待服务。");
                try {
                    Thread.sleep( 5 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            //处理
            deal(number, times);
            times ++;
        }
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < 500000; i++) {
            queue.offer(i);
        }

        Object lock = new Object();

        TicketDemo cx = new TicketDemo(queue, lock, "春香");
        TicketDemo rh = new TicketDemo(queue, lock, "如花");
        TicketDemo qx = new TicketDemo(queue, lock, "秋香");
        TicketDemo dx = new TicketDemo(queue, lock, "冬香");


        if (CollectionUtils.isEmpty(queue)) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("无用户，叫号暂停！");
        }
        cx.start();
        rh.start();
        qx.start();
        dx.start();


    }

}
