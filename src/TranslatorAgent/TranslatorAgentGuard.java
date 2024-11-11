package TranslatorAgent;

//import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.GuardBESA;
//import BESA.Kernel.System.AdmBESA;

import GPSAgent.GPSAgentMessage;
import GyroAgent.GyroAgentMessage;
import WeatherAgent.WeatherAgentMessage;

public class TranslatorAgentGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        Object data = event.getData();

        if (data instanceof GPSAgentMessage) {
            GPSAgentMessage gpsMessage = (GPSAgentMessage) data;
            String gpsData = TranslatorAgentParsing.gpsToXML(gpsMessage.getContent());
            System.out.println(gpsData);
        } else if (data instanceof GyroAgentMessage) {
            GyroAgentMessage gyroMessage = (GyroAgentMessage) data;
            String gyroData = TranslatorAgentParsing.GyroToXML(gyroMessage.getContent());
            System.out.println(gyroData);
        }else if (data instanceof WeatherAgentMessage) {
            WeatherAgentMessage weatherMessage = (WeatherAgentMessage) data;
            String weatherData = TranslatorAgentParsing.WeatherToXML(weatherMessage.getContent());
            System.out.println(weatherData);
        }
    }
}