package ActuatorOneAgent;

import BESA.Kernel.Agent.Event.EventBESA;
import TranslatorAgent.TranslatorAgentGPSMessage;
import TranslatorAgent.TranslatorAgentGyroMessage;
import BESA.Kernel.Agent.GuardBESA;

public class ActuatorOneAgentGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        Object data = event.getData();

        if (data instanceof TranslatorAgentGPSMessage) {
            TranslatorAgentGPSMessage gpsData = (TranslatorAgentGPSMessage) data;
            // Parse data to variables to create a GUI
            System.out.println(gpsData.getContent());
        } else if (data instanceof TranslatorAgentGyroMessage) {
            TranslatorAgentGyroMessage gyroData = (TranslatorAgentGyroMessage) data;
            // Parse data to variables to create a GUI
            System.out.println(gyroData.getContent());
        }
    }
}