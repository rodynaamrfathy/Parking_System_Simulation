public class Semaphore {
    private int value;

    public Semaphore(int initialValue) {
        this.value = initialValue;
    }

    public synchronized void Wait(Thread thread) {
        value--;
        if (value < 0) {
            try {
                wait(); // Thread waits until another thread signals
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Signal() {
        value++;
        if (value <= 0) {
            notify(); // Wake up one waiting thread
        }
    }
}
