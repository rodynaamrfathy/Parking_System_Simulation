public class Garage {
    private ParkingSpot[] ParkingSpots;
    private GarageGate[] GarageGates;
    private static int ParkingSpotCount = 4;
    private static int GarageGateCount = 3;

    private static final Semaphore parkingSemaphore = new Semaphore(ParkingSpotCount);
    private static final Semaphore garageSemaphore = new Semaphore(GarageGateCount);


    public Garage()
    {
        ParkingSpots = new ParkingSpot[ParkingSpotCount];
        GarageGates = new GarageGate[GarageGateCount];
    }
}
