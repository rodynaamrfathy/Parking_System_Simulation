public class Semaphore {
    private int value;

    public Semaphore(int initialValue) {
        this.value = initialValue;
    }

    public synchronized void Wait(Thread thread) {
        value--;
        System.out.println("Semaphore Wait: Value now " + value + " | Thread: " + thread.getName());  // Debugging log

        if (value < 0) {
            try {
                wait(); // Thread waits until another thread signals
                System.out.println("Semaphore Wait: Thread " + thread.getName() + " resumed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Signal() {
        value++;
        System.out.println("Semaphore Signal: Value now " + value);  // Debugging log
        if (value <= 0) {
            notify(); // Wake up one waiting thread
            System.out.println("Semaphore Signal: A thread is notified.");
        }
    }
}