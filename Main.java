package Project331;

import java.util.Random;
import java.io.IOException;

public class Main {

    private static final Random random = new Random();
    private static double previousValidSensor3Value = -1;
    private static final String BASE_LOG_FILE = "log.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileLogger logger = new FileLogger(BASE_LOG_FILE);
		
		
		for (int i = 0; i < 3; i++) {
            double temp = generateTemperature();
            double humidity = generateHumidity();

            double s31 = generateCriticalSensorReading();
            double s32 = generateCriticalSensorReading();
            double s33 = generateCriticalSensorReading();
            
            System.out.printf("Cycle %d:\n", i + 1);
            System.out.printf("Temperature: %.2f °C, Humidity: %.2f %%\n", temp, humidity);
            System.out.printf("Sensor 3.1: %.2f, Sensor 3.2: %.2f, Sensor 3.3: %.2f\n\n", s31, s32, s33);
		
            try {
                Thread.sleep(1500); // Simulate periodic readings
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		
	}



	public static double generateTemperature() {
        return 20 + random.nextDouble() * 15; 
    }

    public static double generateHumidity() {
        return 30 + random.nextDouble() * 50; 
    }

    public static double generateCriticalSensorReading() {
        return 50 + random.nextInt(11); 
    }
	
	
	
	
}
