package TranslatorAgent;

//import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import ActuatorOneAgent.ActuatorOneAgentGuard;
import ActuatorTwoAgent.ActuatorTwoAgentGuard;
import BESA.ExceptionBESA;
import BESA.Kernel.Agent.GuardBESA;
//import BESA.Kernel.System.AdmBESA;

import GPSAgent.GPSAgentMessage;
import GyroAgent.GyroAgentMessage;
import WeatherAgent.WeatherAgentMessage;

public class TranslatorAgentGuard extends GuardBESA {

    private static TranslatorAgentGPSMessage gpsInfo = new TranslatorAgentGPSMessage(null);
    private static TranslatorAgentGyroMessage gyroInfo = new TranslatorAgentGyroMessage(null);
    private static TranslatorAgentWeatherMessage weatherInfo = new TranslatorAgentWeatherMessage(null);

    @Override
    public void funcExecGuard(EventBESA event) {
        Object data = event.getData();

        if (data instanceof GPSAgentMessage) {
            GPSAgentMessage gpsMessage = (GPSAgentMessage) data;
            String gpsData = TranslatorAgentParsing.gpsToXML(gpsMessage.getContent());
            gpsInfo.setContent(gpsData);
            try {
                AdmBESA.getInstance().getHandlerByAlias("ActuatorOne")
                .sendEvent(
                    new EventBESA(
                        ActuatorOneAgentGuard.class.getName(),
                        gpsInfo
                    )
                );
            } catch (ExceptionBESA e) {
                throw new RuntimeException(e);
            }
        } else if (data instanceof GyroAgentMessage) {
            GyroAgentMessage gyroMessage = (GyroAgentMessage) data;
            String gyroData = TranslatorAgentParsing.GyroToXML(gyroMessage.getContent());
            gyroInfo.setContent(gyroData);
            try {
                AdmBESA.getInstance().getHandlerByAlias("ActuatorOne")
                .sendEvent(
                    new EventBESA(
                        ActuatorOneAgentGuard.class.getName(),
                        gyroInfo
                    )
                );
            } catch (ExceptionBESA e) {
                throw new RuntimeException(e);
            }
        }else if (data instanceof WeatherAgentMessage) {
            WeatherAgentMessage weatherMessage = (WeatherAgentMessage) data;
            String weatherData = TranslatorAgentParsing.WeatherToXML(weatherMessage.getContent());
            weatherInfo.setContent(weatherData);
            try {
                AdmBESA.getInstance().getHandlerByAlias("ActuatorTwo")
                .sendEvent(
                    new EventBESA(
                        ActuatorTwoAgentGuard.class.getName(),
                        weatherInfo
                    )
                );
            } catch (ExceptionBESA e) {
                throw new RuntimeException(e);
            }
        }
    }
}