import java.util.Queue;
import java.util.LinkedList;

public class ParkingLot {
    public int capacity;
    public int parkedCars = 0;
    public int totalParkedCars = 0;
    public Queue<Car> parkingQueue = new LinkedList<>();

    public ParkingLot() {
        this.capacity = 4;
    }

    public int getCapacity() {
        return capacity;
    }

    public synchronized void addCarToParkingQueue(Car car) {
        parkingQueue.add(car); // Add the car to the parking queue
    }

    public void startParkingProcess() {
        while (!parkingQueue.isEmpty()) {
            Car car = parkingQueue.poll();
            if (car != null) {
                // Start the car's parking thread
                car.start();
            }
        }
    }

    public synchronized void parkCar(Car car) {
        try {
            Simulator.parkingSpaces.Wait(Thread.currentThread()); // Wait for a parking spot
            Simulator.mutex.Wait(Thread.currentThread()); // Synchronize access to shared resources
            parkedCars++;
            totalParkedCars++;
            System.out.println("Car " + car.getCarId() + " from Gate " + car.getGateId() + " parked. (Parking Status: " + parkedCars + "/" + capacity + ")");
            Simulator.mutex.Signal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void carLeave(Car car) {
        try {
            Simulator.mutex.Wait(Thread.currentThread()); // Synchronize access
            parkedCars--;
            System.out.println("Car " + car.getCarId() + " from Gate " + car.getGateId() + " left after " + car.getParkingDuration() + " units of time. (Parking Status: " + parkedCars + "/" + capacity + ")");
            Simulator.mutex.Signal();
            Simulator.parkingSpaces.Signal(); // Signal that a spot is free
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reportActivity() {
        System.out.println("Parking Lot Report:");
        System.out.println("Total Cars Parked: " + totalParkedCars);
        System.out.println("Current Cars in Parking: " + parkedCars);
    }
}
