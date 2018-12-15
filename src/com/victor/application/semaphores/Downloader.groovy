package com.victor.application.semaphores

import java.util.concurrent.Semaphore

@Singleton
class Downloader {
    Semaphore semaphore = new Semaphore(4, true)

    void downloadData() {
        try {
            semaphore.acquire()
            download()
        } catch (InterruptedException e) {
            e.printStackTrace()
        } finally {
            semaphore.release()
        }
    }

    void download() {
        println("Downloading data...")
        try {
            Thread.sleep(2000)
        } catch (InterruptedException e) {
            e.printStackTrace()
        }
    }

}