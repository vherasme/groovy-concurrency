package com.victor.application.basictheory.volatil

import groovy.transform.Canonical

@Canonical
class Worker implements Runnable {

    volatile boolean isTerminated = false

    @Override
    void run() {
        def i = 0
        while (!isTerminated) {
            println("Hello from worker class: $i")
            try {
                Thread.sleep(300)
                i++
            } catch (InterruptedException e) {
                e.printStackTrace()
            }
        }
    }
}

@Canonical
class VolatileExample {

    void runExample() {
        Worker w = new Worker()
        Thread t1 = new Thread(w)
        t1.start()

        try {
            Thread.sleep(3000)
        } catch (InterruptedException e) {
            e.printStackTrace()
        }

        w.setIsTerminated(true)
        println("finished...")

    }

}