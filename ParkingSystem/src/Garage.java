public class Garage {
    private ParkingSpot[] ParkingSpots;
    private GarageGate[] GarageGates;
    private static int ParkingSpotCount = 4;
    private static int GarageGateCount = 3;

    private static final Semaphore parkingSemaphore = new Semaphore(ParkingSpotCount);
    private static final Semaphore garageSemaphore = new Semaphore(GarageGateCount); // bfkr an dah 8alat w mfrod tb2a fy kol gate
    


    public Garage()
    {
        ParkingSpots = new ParkingSpot[ParkingSpotCount];
        GarageGates = new GarageGate[GarageGateCount];
    }

    public void carEnters(){

    }

    public void carLeavs(){
        
    }

    public void parkCar(){
        parkingSemaphore.Wait();
    }

    public void unparkCar()
    {
        parkingSemaphore.Signal();
    }
}
