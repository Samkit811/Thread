public class ProduceTask implements Runnable {

    SharedResource sharedResource;

    public ProduceTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer Thread: " + Thread.currentThread().getName());
        try{
            Thread.sleep(5000l);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sharedResource.addItem();
    }
}
