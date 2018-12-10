package com.victor.application.runnable

import groovy.transform.Canonical

@Canonical
class RunnerOne implements Runnable {

    @Override
    void run() {
        for (int i = 0; i < 10; i++) {
            println("RunnerOne: $i")
        }
    }
}

@Canonical
class RunnerTwo implements Runnable {

    @Override
    void run() {
        for (int i = 0; i < 10; i++) {
            println("RunnerTwo: $i")
        }
    }
}

class RunnableImpl {

    void runExample() {
        def t1 = new Thread(new RunnerOne())
        def t2 = new Thread(new RunnerTwo())

        t1.start()
        t2.start()
    }
}
