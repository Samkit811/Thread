public class Main {
    public static void main(String[] args) {

        System.out.println("Main method start");

        SharedResource sharedResource = new SharedResource();

        ProduceTask produceTask = new ProduceTask(sharedResource);
        ConsumeTask consumeTask = new ConsumeTask(sharedResource);

    }
}