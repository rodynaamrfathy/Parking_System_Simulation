import java.time.Duration;

public class Car extends Thread{

    int carID;
    int gateNumber;
    Duration parkingDuration;
    Duration arrivalTimes;
    int parkingSpot;

    public void run()
    {
        try {

            Thread.sleep(arrivalTimes);
            Thread.sleep(parkingDuration);

        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }

    }
}
