package com.victor.application.waitnotify

import groovy.transform.Canonical

@Canonical
class WaitNotify {

    void produce() throws InterruptedException {
        synchronized (this) {
            println("In the Producer method")
            wait()
            Thread.sleep(1000)
            println("Again Producer method")
        }
    }

    void consume() throws InterruptedException {

        Thread.sleep(1000)
        synchronized (this) {
            println("In the Consumer method...")
            notifyAll()
        }
    }

    void runExample() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            void run() {
                produce()
            }
        })

        Thread t2 = new Thread(new Runnable() {
            @Override
            void run() {
                consume()
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
}
