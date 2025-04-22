public class SharedResource {

    boolean itemAvailable = false;

    // synchronized put monitor lock
    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item Added By: " + Thread.currentThread().getName() + " and invoking all the threads which are waiting" + " at time: " + System.currentTimeMillis());
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consume Method invoke by: " + Thread.currentThread().getName() + " at time: " + System.currentTimeMillis());

        while(!itemAvailable){
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now." + " at time: " + System.currentTimeMillis());
                wait(); // It release all monitor lock
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Item consumed by: " + Thread.currentThread().getName() + " at time: " + System.currentTimeMillis());
        itemAvailable = false;
    }

}
