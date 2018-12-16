package com.victor.application.callablefuture

import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class CallableFuture {

    final int cores = Runtime.getRuntime().availableProcessors()

    void runExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(cores)

        List<Future<String>> list = [] // Groovy idiomatic

        for (int i = 0; i < cores; i++) {
            Future<String> future = executorService.submit(new Processor(i + 1))
            list << future
        }

        list.each {
            try {
                println it.get()
            } catch (InterruptedException e) {
                e.printStackTrace()
            } catch (ExecutionException f) {
                f.printStackTrace()
            }
        }

        executorService.shutdown()

    }
}

class Processor implements Callable<String> {

    int id

    Processor(int iD) {
        id = iD
    }

    @Override
    String call() throws Exception {

        Thread.sleep(1000)
        return "id = $id"
    }
}