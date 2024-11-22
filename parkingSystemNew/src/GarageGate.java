import java.util.Queue;
import java.util.LinkedList;

public class GarageGate extends Thread {
    private int gate_id;  // Gate ID now starts from 1
    private Queue<Car> carQueue = new LinkedList<>();
    private int gate_served = 0;

    public GarageGate(int gate_id) {
        this.gate_id = gate_id;
    }

    @Override
    public void run() {
        while (!carQueue.isEmpty()) {
            Car car = carQueue.poll(); // Get the next car in the queue
            if (car != null) {
                // Add the car to the parking lot
                Simulator.parkingLot.addCarToParkingQueue(car);
                gate_served++;
            }
        }
    }

    public void add_car(Car car) {
        carQueue.add(car);
    }

    public void report_activity() {
        System.out.println("Gate " + gate_id + " served " + gate_served + " cars.");
    }
}
