public class Main {
    public static void main(String[] args) {

        System.out.println("Main method start" + " at time: " + System.currentTimeMillis());

        System.out.println("------------- Shared Resource Implementation --------------");
        SharedResource sharedResource = new SharedResource();

        ProduceTask produceTask = new ProduceTask(sharedResource);
        ConsumeTask consumeTask = new ConsumeTask(sharedResource);

        //Thread making
        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        // Thread is in runnable state
        producerThread.start();
        consumerThread.start();

        System.out.println("------------- Shared Buffer Implementation --------------");

        // Shared Buffer Implementation start
        SharedBuffer sharedBuffer = new SharedBuffer(2);

        Thread producerBufferThread1 = new Thread(() -> {
            sharedBuffer.addBufferItem();
        });

        Thread consumerBufferThread1 = new Thread(() -> {
            sharedBuffer.consumeBufferItem();
        });

        Thread producerBufferThread2 = new Thread(() -> {
            sharedBuffer.addBufferItem();
        });

        Thread consumerBufferThread2 = new Thread(() -> {
            sharedBuffer.consumeBufferItem();
        });

        Thread producerBufferThread3 = new Thread(() -> {
            sharedBuffer.addBufferItem();
        });

        Thread consumerBufferThread3 = new Thread(() -> {
            sharedBuffer.consumeBufferItem();
        });

        consumerBufferThread1.start();
        producerBufferThread1.start();
        producerBufferThread2.start();
        producerBufferThread3.start();
        consumerBufferThread2.start();

        System.out.println("Main method ends" + " at time: " + System.currentTimeMillis());

    }
}