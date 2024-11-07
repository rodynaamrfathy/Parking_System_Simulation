
public class Garage {
    private ParkingSpot[] ParkingSpots;
    private GarageGate[] GarageGates;
    private int ParkingSpotCount = 4;
    private int GarageGateCount = 3;

    public Garage()
    {
        ParkingSpots = new ParkingSpot[ParkingSpotCount];
        GarageGates = new GarageGate[GarageGateCount];
    }

}
