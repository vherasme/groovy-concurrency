package com.victor.application

import com.victor.application.produceconsumelocks.ProduceConsumeLocks

class Application {

    static void main(String[] args) {

        def p = new ProduceConsumeLocks()
        p.runExample()
    }
}
