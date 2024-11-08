package GPSAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.System.AdmBESA;
import java.util.logging.Level;
import java.util.logging.Logger;

import TranslatorAgent.TranslatorAgentGuard;

public class GPSAgentGuard extends PeriodicGuardBESA {

    @Override
    public void funcPeriodicExecGuard(EventBESA eventBESA) {
        try {
            AdmBESA.getInstance().getHandlerByAlias("Translator")
            .sendEvent(
                new EventBESA(
                    TranslatorAgentGuard.class.getName(),
                    new GPSAgentMessage("SensorGPSInfo")
                )
            );
        } catch (ExceptionBESA e) {
            throw new RuntimeException(e);
        }
    }

}