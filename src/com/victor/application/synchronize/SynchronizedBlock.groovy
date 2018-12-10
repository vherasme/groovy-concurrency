package com.victor.application.synchronize

class SynchronizedBlock {

    private static int count1 = 0
    private static int count2 = 0

    private static synchronized void add() {

        synchronized (count1) {
            count1++
        }
    }

    private static synchronized void addAgain() {
        synchronized (count2) {
            count2++
        }
    }

    private static void compute() {
        for (int i = 0; i < 100; i++) {
            add()
            addAgain()
        }
    }

    void runExample() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            void run() {
                compute()
            }
        })

        Thread t2 = new Thread(new Runnable() {
            @Override
            void run() {
                compute()
            }
        })

        t1.start()
        t2.start()

        try {
            t1.join()
            t2.join()
        } catch (InterruptedException e) {
            e.printStackTrace()
        }

        println "count1 = $count1 \ncount2 = $count2"
    }
}
