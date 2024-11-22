public class Car extends Thread {
    private final int carId;
    private final int gateId;
    private final int parkingDuration;
    private final int arrivalTime;
    private final ParkingLot parkingLot;

    public Car(int carId, int gateId, int arrivalTime, int parkingDuration, ParkingLot parkingLot) {
        this.carId = carId;
        this.gateId = gateId;
        this.arrivalTime = arrivalTime;
        this.parkingDuration = parkingDuration;
        this.parkingLot = parkingLot;
    }

    public int getCarId() {
        return carId;
    }

    public int getGateId() {
        return gateId;
    }

    public int getParkingDuration() {
        return parkingDuration;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(arrivalTime * 1000); // Simulate arrival time
            parkingLot.parkCar(this);  // Handle parking logic here
            try {
                Thread.sleep(parkingDuration * 1000); // Simulate parking duration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parkingLot.carLeave(this);  // Handle car leaving after parking duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
