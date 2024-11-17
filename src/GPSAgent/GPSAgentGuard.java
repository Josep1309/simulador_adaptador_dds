package GPSAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.System.AdmBESA;

import TranslatorAgent.TranslatorAgentGuard;

public class GPSAgentGuard extends PeriodicGuardBESA {
    @Override
    public void funcPeriodicExecGuard(EventBESA eventBESA) {
        GPSAgentState gpsAgentState = (GPSAgentState) this.getAgent().getState();
        try {
            AdmBESA.getInstance().getHandlerByAlias("Translator")
            .sendEvent(
                new EventBESA(
                    TranslatorAgentGuard.class.getName(),
                    new GPSAgentMessage(gpsAgentState)
                )
            );
        } catch (ExceptionBESA e) {
            throw new RuntimeException(e);
        }
    }
}