package MaritimeLogAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.System.AdmBESA;
import TranslatorAgent.TranslatorAgentGuard;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MaritimeLogAgentGuard extends PeriodicGuardBESA {

    @Override
    public void funcPeriodicExecGuard(EventBESA eventBESA) {
        try {
            AdmBESA.getInstance().getHandlerByAlias("Translator")
            .sendEvent(
                new EventBESA(
                    TranslatorAgentGuard.class.getName(),
                    new MaritimeLogAgentMessage("SensorCorrederaInfo")
                )
            );
        } catch (ExceptionBESA e) {
            throw new RuntimeException(e);
        }
    }
    
}