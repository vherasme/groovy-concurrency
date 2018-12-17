package com.victor.application

import com.victor.application.parallelcollections.countdownlatches.RunLatchWorker

class Application {

    static void main(String[] args) {

        def example = new RunLatchWorker()
        example.runExample()
    }
}
