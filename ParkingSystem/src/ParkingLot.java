public class ParkingLot {
    private int capacity = 4;
    private Semaphore parkingSpot = new Semaphore(capacity); 
    private int totalCarsParked = 0;

    public synchronized void park_car(Car car) {
        parkingSpot.Wait();
        totalCarsParked++;
        System.out.println("Car " + car.car_id + " from Gate " + car.gate_id + " parked. Total parked: " + totalCarsParked);
    }

    public synchronized void car_leave(Car car) {
        parkingSpot.Signal();
        System.out.println("Car " + car.car_id + " left. Total parked: " + totalCarsParked);
    }

    public void report_activity() {
        System.out.println("Parking lot activity completed.");
    }
}
