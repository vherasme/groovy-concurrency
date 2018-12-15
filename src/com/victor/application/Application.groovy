package com.victor.application

import com.victor.application.semaphores.UsingSemaphore

class Application {

    static void main(String[] args) {

        def example = new UsingSemaphore()
        example.runExample()
    }
}
