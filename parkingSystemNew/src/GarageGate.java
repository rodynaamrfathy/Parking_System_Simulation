import java.util.Queue;
import java.util.LinkedList;

public class GarageGate extends Thread {
    private int gate_id;
    private Queue<Car> carQueue = new LinkedList<>();
    private int gate_served = 0;

    public GarageGate(int gate_id) {
        this.gate_id = gate_id;
    }

    @Override
    public void run() {
        // Process cars in the queue until it is empty
        while (true) {
            Car car = null;
            synchronized (this) {
                if (!carQueue.isEmpty()) {
                    car = carQueue.poll(); // Get the next car in the queue
                }
            }

            if (car != null) {
                // Add the car to the parking lot
                Simulator.parkingLot.addCarToParkingQueue(car);
                gate_served++;
            } else {
                break;  // Exit when there are no cars left to process
            }
        }
    }

    public void add_car(Car car) {
        synchronized (this) {
            carQueue.add(car); // Add car to the queue
        }
    }

    public void report_activity() {
        System.out.println("Gate " + gate_id + " served " + gate_served + " cars.");
    }
}

