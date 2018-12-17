package com.victor.application.basictheory.executors

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class RunExecuteWorker {

    final int cores = Runtime.getRuntime().availableProcessors()

    void runExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(cores)

        for (int i = 0; i < cores; i++) {
            executorService.submit(new ExecuteThreadWorker())
        }
        executorService.shutdown()
    }
}

class ExecuteThreadWorker implements Runnable {

    @Override
    void run() {
        for (int i = 0; i < 10; i++) {
            println(i)

            try {
                Thread.sleep(300)
            } catch (InterruptedException e) {
                e.printStackTrace()
            }
        }
    }
}
