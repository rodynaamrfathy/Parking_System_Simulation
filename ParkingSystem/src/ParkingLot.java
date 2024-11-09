public class ParkingLot {
    private int capacity = 4;
    private Semaphore parkingSpot = new Semaphore(capacity); 
    public int parked_cars = 0;
    public int Total_parked_cars = 0;

    public synchronized void park_car(Car car) {
        parked_cars++;
        Total_parked_cars++;
        parkingSpot.Wait();
        System.out.println("Car " + car.car_id + " from Gate " + car.gate_id + " arrived at time " + car.arrival_time);
    }

    public synchronized void car_leave(Car car) {
        parkingSpot.Signal();
        parked_cars--;
        System.out.println("Car " + car.car_id + " from Gate " + car.gate_id + " left after " + car.parking_duration + " units of time. (Parking Status: " + parked_cars + " spots occupied)");
    }

    public void report_activity() {
        System.out.println("Total Cars Served: " + Total_parked_cars);
        System.out.println("Current Cars in Parking: " + (parked_cars));
    }
}
