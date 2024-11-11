package ActuatorTwoAgent;

import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.GuardBESA;
import TranslatorAgent.TranslatorAgentWeatherMessage;

public class ActuatorTwoAgentGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        Object data = event.getData();

        if (data instanceof TranslatorAgentWeatherMessage) {
            TranslatorAgentWeatherMessage weatherData = (TranslatorAgentWeatherMessage) data;
            // Parse data to variables to create a GUI
            System.out.println(weatherData.getContent());
        }
    }
}