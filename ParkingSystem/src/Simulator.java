import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    private ParkingLot parkingLot;
    private GarageGate[] garageGates;
    private static final int GarageGateCount = 3;

    public Simulator() {
        parkingLot = new ParkingLot();
        garageGates = new GarageGate[GarageGateCount];
        for (int i = 0; i < GarageGateCount; i++) {
            garageGates[i] = new GarageGate(i + 1);
        }
    }

    public void read_Input(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                int gate_id = Integer.parseInt(parts[0].split(" ")[1]) - 1;
                int car_id = Integer.parseInt(parts[1].split(" ")[1]);
                int arrival_time = Integer.parseInt(parts[2].split(" ")[1]);
                int parking_duration = Integer.parseInt(parts[3].split(" ")[1]);

                Car car = new Car(car_id, gate_id, arrival_time, parking_duration, parkingLot);
                garageGates[gate_id].add_car(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start_Simulation() {
        for (GarageGate gate : garageGates) {
            gate.start();
        }
        for (GarageGate gate : garageGates) {
            try {
                gate.join(); // Wait for all gates to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void report()
    {
        parkingLot.report_activity();
        for(GarageGate gate : garageGates) {
            gate.report_activity();
        }
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.read_Input("car_data.txt");
        simulator.start_Simulation();
        simulator.report();
    }
}
