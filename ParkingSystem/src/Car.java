public class Car extends Thread {
    int car_id;
    int gate_id;
    int parking_duration;
    int arrival_time;
    ParkingLot parkingLot;

    public Car(int car_id, int gate_id, int arrival_time, int parking_duration, ParkingLot parkingLot) {
        this.car_id = car_id;
        this.gate_id = gate_id;
        this.arrival_time = arrival_time;
        this.parking_duration = parking_duration;
        this.parkingLot = parkingLot;
    }

    public void run() {
        try {
            Thread.sleep(arrival_time * 1000); // Simulate car arrival
            try_to_park();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void try_to_park() {
        parkingLot.park_car(this);
        try {
            Thread.sleep(parking_duration * 1000); // Simulate parking duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parkingLot.car_leave(this);
    }
}
