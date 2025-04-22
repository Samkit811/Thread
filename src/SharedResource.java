public class SharedResource {

    boolean itemAvailable = false;

    // synchronized put monitor lock
    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item Added By: " + Thread.currentThread().getName() + " and invoking all the threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consume Method invoke by: " + Thread.currentThread().getName());

        while(!itemAvailable){
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now.");
                wait(); // It release all monitor lock
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemAvailable = false;
    }

}
