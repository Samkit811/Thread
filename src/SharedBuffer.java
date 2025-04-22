import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class SharedBuffer {
    private Queue<Integer> sharedResource;
    int resourceSize;
    Random random;

    public SharedBuffer(int resourceSize) {
        System.out.println("Shared Buffer is initialized");
        this.resourceSize = resourceSize;
        this.sharedResource = new ArrayDeque<>();
        this.random = new Random();
    }

    public synchronized void addBufferItem() {
        while(this.sharedResource.size() == this.resourceSize){
            try {
                System.out.println("Producer Buffer Thread: " + Thread.currentThread().getName() + " is waiting.");
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        /*
        * Item will be selected randomly between 0 and 99
        */
        int itemVal = random.nextInt(100);
        this.sharedResource.add(itemVal);
        System.out.println("Producer Buffer Thread: " + Thread.currentThread().getName() + " is adding " + itemVal + " to Buffer.");
        notifyAll();
    }

    public synchronized void consumeBufferItem() {
        while(this.sharedResource.isEmpty()){
            try {
                System.out.println("Consumer Buffer Thread: " + Thread.currentThread().getName() + " is waiting.");
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        int itemVal = this.sharedResource.poll();
        System.out.println("Consumer Buffer Thread: " + Thread.currentThread().getName() + " has consumed item which value is: " + itemVal);
        notifyAll();
    }
}
