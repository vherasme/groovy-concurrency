package com.victor.application.basictheory.semaphores

import groovy.transform.Canonical
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Canonical
class UsingSemaphore {

    void runExample() {

        ExecutorService executorService = Executors.newCachedThreadPool()

        for (int i = 0; i < 12; i++) {
            executorService.execute(new Runnable() {
                @Override
                void run() {
                    Downloader.getInstance().downloadData()
                }
            })
        }
        executorService.shutdown()
    }
}
