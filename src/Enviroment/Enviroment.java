package Enviroment;

// Besa libs
import BESA.ExceptionBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Kernel.Agent.Event.EventBESA;

import SellingAgent.SellingAgent;
import SellingAgent.SellingAgentGuard;
import BuyerAgent.BuyerAgent;

// Agents
import GPSAgent.GPSAgent;
import GyroAgent.GyroAgent;
import MaritimeLogAgent.MaritimeLogAgent;
import WeatherAgent.WeatherAgent;
import TranslatorAgent.TranslatorAgent;
import ActuatorOneAgent.ActuatorOneAgent;
import ActuatorTwoAgent.ActuatorTwoAgent;

public class Enviroment {
    public static void main(String[] args) throws ExceptionBESA {
        // Initialize the BESA administration system.
        AdmBESA admBesa = AdmBESA.getInstance();
        
        // Create a new SellingAgent with the alias "HolaMundo".
        GPSAgent gpsAgent = GPSAgent.createAgent("GPS");
        MaritimeLogAgent maritimeLogAgent = MaritimeLogAgent.createAgent("MaritimeLog");
        
        // Start the SellingAgent.
        gpsAgent.start();
        
        // Retrieve the agent's handler by its alias and send an event to the SellingAgentGuard.
        admBesa.getHandlerByAlias("comprador").sendEvent(new EventBESA(
                        SellingAgentGuard.class.getName(), 
                        null
                )
        );
    }
}
