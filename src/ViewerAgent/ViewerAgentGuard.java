package ViewerAgent;

import ActuatorOneAgent.ActuatorOneAgentState;
import ActuatorTwoAgent.ActuatorTwoAgentState;
import BESA.ExceptionBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;

import GPSAgent.GPSAgentState;
import GyroAgent.GyroAgentState;
import WeatherAgent.WeatherAgentState;

import java.io.IOException;

public class ViewerAgentGuard extends PeriodicGuardBESA {

    public static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void funcPeriodicExecGuard(EventBESA eventBESA) {

        String gpsMessage = null;
        String gyroMessage = null;
        String weatherMessage = null;

        ViewerAgentState viewerAgentState = (ViewerAgentState) this.getAgent().getState();
        
        try {
            ActuatorOneAgentState actuatorOneAgentState = (ActuatorOneAgentState) AdmBESA.getInstance().getHandlerByAlias("ActuatorOne").getAg().getState();
            viewerAgentState.setLatitude(actuatorOneAgentState.getLatitude());
            viewerAgentState.setLatitudeDirection(actuatorOneAgentState.getLatitudeDirection());
            viewerAgentState.setLongitude(actuatorOneAgentState.getLongitude());
            viewerAgentState.setLongitudeDirection(actuatorOneAgentState.getLongitudeDirection());
            viewerAgentState.setAltitude(actuatorOneAgentState.getAltitude());
            viewerAgentState.setAltitudeUnits(actuatorOneAgentState.getAltitudeUnits());
            viewerAgentState.setMagneticHeading(actuatorOneAgentState.getMagneticHeading());
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }

        try {
            ActuatorTwoAgentState actuatorTwoAgentState = (ActuatorTwoAgentState) AdmBESA.getInstance().getHandlerByAlias("ActuatorTwo").getAg().getState();
            viewerAgentState.setTrueWindDirection(actuatorTwoAgentState.getTrueWindDirection());
            viewerAgentState.setWindSpeedKnots(actuatorTwoAgentState.getWindSpeedKnots());
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }

        try {
            GPSAgentState gpsState = (GPSAgentState) AdmBESA.getInstance().getHandlerByAlias("GPS").getAg().getState();
            gpsMessage = gpsState.getContent();
            GyroAgentState gyroState = (GyroAgentState) AdmBESA.getInstance().getHandlerByAlias("Gyro").getAg().getState();
            gyroMessage = gyroState.getContent();
            WeatherAgentState weatherState = (WeatherAgentState) AdmBESA.getInstance().getHandlerByAlias("Weather").getAg().getState();
            weatherMessage = weatherState.getContent();
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }

        String printFormat = String.format("""
            Sensors data visualization:
            GPS -- %s
            GyroCompass -- %s
            Wind -- %s


            Final Actuators visualization:
            Latitude -- %s %s
            Longitude -- %s %s
            Altitude -- %s %s

            Heading -- %s

            Wind direction -- %s
            Wind speed (Knots) -- %s
            """, 
            gpsMessage,
            gyroMessage,
            weatherMessage,
            viewerAgentState.getLatitude(),
            viewerAgentState.getLatitudeDirection(),
            viewerAgentState.getLongitude(),
            viewerAgentState.getLongitudeDirection(),
            viewerAgentState.getAltitude(),
            viewerAgentState.getAltitudeUnits(),
            viewerAgentState.getMagneticHeading(),
            viewerAgentState.getTrueWindDirection(),
            viewerAgentState.getWindSpeedKnots()
        );
        
        limpiarConsola();
        System.out.println(printFormat);
    }
}