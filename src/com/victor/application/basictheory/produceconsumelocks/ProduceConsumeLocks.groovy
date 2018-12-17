package com.victor.application.basictheory.produceconsumelocks

import groovy.transform.Canonical

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

@Canonical
class ProduceConsumeLocks {

    Lock lock = new ReentrantLock()
    Condition condition = lock.newCondition()

    void producer() throws InterruptedException {
        lock.lock()
        println("Producer method...")
        condition.await()
        println("Producer again...")
        lock.unlock()
    }

    void consumer() throws InterruptedException {
        lock.lock()
        Thread.sleep(2000)
        println("Consumer method...")
        condition.signal()
        lock.unlock()
    }

    void runExample() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            void run() {
                producer()
            }
        })

        Thread t2 = new Thread(new Runnable() {
            @Override
            void run() {
                consumer()
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