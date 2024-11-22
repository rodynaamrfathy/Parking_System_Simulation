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
            // Simulate arrival time
            Thread.sleep(arrivalTime * 1000); 
            System.out.println("Car " + carId + " from Gate " + gateId + " arrived at parking lot.");
            
            // Handle parking logic
            parkingLot.parkCar(this);  
            
            // Simulate parking duration
            int time = getParkingDuration() * 100;
            Thread.sleep(time); // should be time msh 1000 
            
            // Handle car leaving
            parkingLot.carLeave(this);  
            System.out.println("Car " + carId + " from Gate " + gateId + " is leaving.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
