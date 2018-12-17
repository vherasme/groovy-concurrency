package com.victor.application.parallelcollections.countdownlatches

import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LatchWorker implements Runnable {

    int id
    CountDownLatch countDownLatch

    LatchWorker(int id, CountDownLatch countDownLatch) {
        this.id = id
        this.countDownLatch = countDownLatch
    }

    @Override
    void run() {
        doWork()
        countDownLatch.countDown()
    }

    def doWork() {

        println("Thread with id $id starts working")

        try {
            Thread.sleep(1000)
        } catch (InterruptedException e) {
            e.printStackTrace()
        }
    }
}

class RunLatchWorker {

    void runExample() {

        ExecutorService executorService = Executors.newSingleThreadExecutor()

        CountDownLatch latch = new CountDownLatch(4)

        for (int i = 0; i < 4; i++) {
            executorService.execute(new LatchWorker(i + 1, latch))
        }

        try {
            latch.await()
        } catch (InterruptedException e) {
            e.printStackTrace()
        }

        println("All the prerequisites are done...")

        executorService.shutdown()
    }
}
