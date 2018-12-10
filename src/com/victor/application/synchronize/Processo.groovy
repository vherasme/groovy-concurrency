package com.victor.application.synchronize

import groovy.transform.Canonical

@Canonical
class Processo {

    public static int counter = 0

    private static synchronized void increment() {
        ++counter
    }

    private static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            void run() {
                for (int i = 0; i < 100; i++) {
                    increment()
                }

            }
        })

        Thread t2 = new Thread(new Runnable() {
            @Override
            void run() {
                for (int j = 0; j < 100; j++) {
                    increment()
                }
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
    }

    static void runExample() {
        process()
        println(counter)
    }

}