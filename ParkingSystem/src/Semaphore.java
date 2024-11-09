public class Semaphore {
    private int value;

    public Semaphore(int initialValue) {
        this.value = initialValue;
    }

    public synchronized void Wait() {
        while (value <= 0) {
            try {
                wait(); // Wait until parking spot is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        value--;
    }
    
    public synchronized void Signal() {
        value++;
        if (value > 0) {
            notify(); // Notify the next waiting thread
        }
    }    
}