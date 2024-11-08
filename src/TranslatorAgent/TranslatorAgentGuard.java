package TranslatorAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.System.AdmBESA;

import GPSAgent.GPSAgentMessage;
import GyroAgent.GyroAgentMessage;
import MaritimeLogAgent.MaritimeLogAgentMessage;
import WeatherAgent.WeatherAgentMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TranslatorAgentGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        Object data = event.getData();

        if (data instanceof GPSAgentMessage) {
            GPSAgentMessage gpsAgentMessage = (GPSAgentMessage) data;
            System.out.println(gpsAgentMessage.getContenido());
        } else if (data instanceof GyroAgentMessage) {
            GyroAgentMessage gyroAgentMessage = (GyroAgentMessage) data;
            System.out.println(gyroAgentMessage.getContenido());
        } else if (data instanceof MaritimeLogAgentMessage) {
            MaritimeLogAgentMessage maritimeLogAgentMessage = (MaritimeLogAgentMessage) data;
            System.out.println(maritimeLogAgentMessage.getContenido());
        } else if (data instanceof WeatherAgentMessage) {
            WeatherAgentMessage weatherAgentMessage = (WeatherAgentMessage) data;
            System.out.println(weatherAgentMessage.getContenido());
        }
        
    }
}