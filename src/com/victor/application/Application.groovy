package com.victor.application

import com.victor.application.callablefuture.CallableFuture

class Application {

    static void main(String[] args) {

        def example = new CallableFuture()
        example.runExample()
    }
}
