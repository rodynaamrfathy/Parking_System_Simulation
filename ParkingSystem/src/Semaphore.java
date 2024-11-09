import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {
    private int value;
    private final Queue<Thread> waitingQueue;

    public Semaphore(int initialValue) {
        this.value = initialValue;
        this.waitingQueue = new LinkedList<>();
    }

    public synchronized void Wait() {
        value--; 
        if (value < 0) {
            waitingQueue.add(Thread.currentThread());
            try {
                while (waitingQueue.contains(Thread.currentThread())) {
                    wait(); 
                }
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted while waiting: " + Thread.currentThread().getName());
            }
        }
    }

    public synchronized void Signal() {
        value++; 
        if (value <= 0) {
            Thread nextThread = waitingQueue.poll();
            if (nextThread != null) {
                notifyAll();
            }
        }
    }
}
