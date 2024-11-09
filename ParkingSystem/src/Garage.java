public class Garage {
    private ParkingSpot[] ParkingSpots;
    private GarageGate[] GarageGates;
    private static int ParkingSpotCount = 4;
    private int GarageGateCount = 3;

    private static final Semaphore semaphore = new Semaphore(ParkingSpotCount);

    public Garage()
    {
        ParkingSpots = new ParkingSpot[ParkingSpotCount];
        GarageGates = new GarageGate[GarageGateCount];
    }
}
