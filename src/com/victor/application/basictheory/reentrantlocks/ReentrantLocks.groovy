package com.victor.application.basictheory.reentrantlocks

import groovy.transform.Canonical

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

@Canonical
class ReentrantLocks {

    static int counter = 0
    static Lock lock = new ReentrantLock()

    static void increment() {
        lock.lock()
        try {
            for (int i = 0; i < 10000; i++) {
                counter++
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            lock.unlock()
        }

    }

    static void add() {
        //unlock can be used at any part of the code
        lock.unlock()
    }

    void runExample() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            void run() {
                increment()
            }
        })

        Thread t2 = new Thread(new Runnable() {
            @Override
            void run() {
                increment()
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

        println("counter = $counter")

    }

}
