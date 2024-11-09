import java.util.Queue;
import java.util.LinkedList;

public class GarageGate extends Thread {
    public int gate_id;
    public Queue<Car> carQueue = new LinkedList<>();

    public GarageGate(int gate_id) {
        this.gate_id = gate_id;
    }

    @Override
    public void run() {
        while (!carQueue.isEmpty()) {
            Car car = carQueue.poll();
            // hena dlw2ty car gaya w arival bt3ha 7 y3ni hto2f ala el gate 7 sec w b3din tb2a ready tt5ol
            // lw fy whda gat ablha htt5ol threads mmsh bt7km feha
            car.start();
        }
    }

    public void add_car(Car car) {
        carQueue.add(car);
    }
}
