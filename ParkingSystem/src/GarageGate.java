import java.util.Queue;
import java.util.LinkedList;

public class GarageGate extends Thread {
    public int gate_id;
    public Queue<Car> carQueue = new LinkedList<>();
    private int gate_served = 0;

    public GarageGate(int gate_id) {
        this.gate_id = gate_id;
    }

    @Override
    public void run() {
        while (!carQueue.isEmpty()) {
            Car car = carQueue.poll();
            car.start();  // Start the car thread
            try {
                car.join();  // Wait for the car thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gate_served++;
        }
    }

    public void add_car(Car car) {
        carQueue.add(car);
    }

    public void report_activity() {
        System.out.println("Gate " + gate_id + " served " + gate_served + " cars.");
    }
}
