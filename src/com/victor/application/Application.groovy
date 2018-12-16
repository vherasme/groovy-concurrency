package com.victor.application

import com.victor.application.executors.RunExecuteWorker

class Application {

    static void main(String[] args) {

        def example = new RunExecuteWorker()
        example.runExample()
    }
}
