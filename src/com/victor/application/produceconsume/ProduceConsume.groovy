package com.victor.application.produceconsume

class ProduceConsume {

    List<Integer> list = new ArrayList<>()
    final int LIMIT = 5
    final int BOTTOM = 0
    private int value = 0

    void produce() throws InterruptedException {
        synchronized (list) {
            while (true) {
                if (list.size() == LIMIT) {
                    println("Waiting to remove items from the list")
                    list.wait()
                } else {
                    println("Adding value = $value")
                    list.add(value)
                    value++
                    list.notify()
                }
                Thread.sleep(500)
            }
        }
    }

    void consume() throws InterruptedException {
        synchronized (list) {
            while (true) {
                if (list.size() == BOTTOM) {
                    println("Waiting to add items to the list")
                    list.wait()
                } else {
                    println("Removed: " + list.remove(list.size() - 1))
                    value--
                    list.notify()
                }
                Thread.sleep(500)
            }
        }
    }

    void runExample() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            void run() {
                try {
                    produce()
                } catch (InterruptedException e) {
                    e.printStackTrace()
                }
            }
        })

        Thread t2 = new Thread(new Runnable() {
            @Override
            void run() {
                try {
                    consume()
                } catch (InterruptedException e) {
                    e.printStackTrace()
                }
            }
        })

        t1.start()
        t2.start()
    }
}
