package GyroAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.System.AdmBESA;
import TranslatorAgent.TranslatorAgentGuard;

public class GyroAgentGuard extends PeriodicGuardBESA {

    @Override
    public void funcPeriodicExecGuard(EventBESA eventBESA) {
        try {
            AdmBESA.getInstance().getHandlerByAlias("Translator")
            .sendEvent(
                new EventBESA(
                    TranslatorAgentGuard.class.getName(),
                    new GyroAgentMessage()
                )
            );
        } catch (ExceptionBESA e) {
            throw new RuntimeException(e);
        }
    }
    
}