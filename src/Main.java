public class Main {
    public static void main(String[] args) {

        System.out.println("Main method start");

        SharedResource sharedResource = new SharedResource();

        ProduceTask produceTask = new ProduceTask(sharedResource);
        ConsumeTask consumeTask = new ConsumeTask(sharedResource);

        //Thread making
        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        // Thread is in runnable state
        producerThread.start();
        consumerThread.start();

        System.out.println("Main method ends");

    }
}