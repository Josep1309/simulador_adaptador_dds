package Enviroment;

// Besa libs
import BESA.ExceptionBESA;
//import BESA.Kernel.System.AdmBESA;
//import BESA.Kernel.Agent.Event.EventBESA;

// Agents
import GPSAgent.GPSAgent;
import GyroAgent.GyroAgent;
import WeatherAgent.WeatherAgent;
import TranslatorAgent.TranslatorAgent;
import ViewerAgent.ViewerAgent;
import ActuatorOneAgent.ActuatorOneAgent;
import ActuatorTwoAgent.ActuatorTwoAgent;

public class Enviroment {
    public static void main(String[] args) throws ExceptionBESA {
        // Initialize the BESA administration system.
        //AdmBESA admBesa = AdmBESA.getInstance();
        
        // Create new agents with alias
        GPSAgent gpsAgent = GPSAgent.createAgent("GPS");
        GyroAgent gyroAgent = GyroAgent.createAgent("Gyro");
        WeatherAgent weatherAgent = WeatherAgent.createAgent("Weather");
        TranslatorAgent translatorAgent = TranslatorAgent.createAgent("Translator");
        ActuatorOneAgent actuatorOneAgent = ActuatorOneAgent.createAgent("ActuatorOne");
        ActuatorTwoAgent actuatorTwoAgent = ActuatorTwoAgent.createAgent("ActuatorTwo");
        ViewerAgent viewerAgent = ViewerAgent.createAgent("Viewer");
        
        // Start the main agents.
        translatorAgent.start();
        viewerAgent.start();
        // Wait one second before start the sensors signals
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Start the sensors
        gpsAgent.start();
        gyroAgent.start();
        weatherAgent.start();
        // Start the actuators
        actuatorOneAgent.start();
        actuatorTwoAgent.start();
    }
}