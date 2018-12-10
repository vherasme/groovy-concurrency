package com.victor.application.threadext

import groovy.transform.Canonical

@Canonical
class ExtendOne extends Thread {

    @Override
    void run() {
        for (int i = 0; i < 25; i++) {
            println("ExtendOne: $i")
            Thread.sleep(100)
        }
    }
}

@Canonical
class ExtendTwo extends Thread {

    @Override
    void run() {
        for (int i = 0; i < 25; i++) {
            println("ExtendTwo: $i")
            Thread.sleep(100)
        }
    }
}

class ExtendThread {

    void runExample() {
        def e1 = new ExtendOne()
        def e2 = new ExtendTwo()
        e1.start()
        e2.start()
    }

    void joinExample() {

        def e1 = new ExtendOne()
        def e2 = new ExtendTwo()

        e1.start()
        e2.start()

        try {
            e1.join()
            e2.join()
        } catch (InterruptedException e) {

            e.printStackTrace()
        }
    }
}
