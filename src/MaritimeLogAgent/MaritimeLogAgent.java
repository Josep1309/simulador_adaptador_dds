package MaritimeLogAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Util.PeriodicDataBESA;
import TranslatorAgent.TranslatorAgent;

public class MaritimeLogAgent extends AgentBESA{
    public MaritimeLogAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }
    
    public static MaritimeLogAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new MaritimeLogAgent(
                alias,
                createState(),
                createStruct(
                        new StructBESA()
                ),
                passwd
        );
    }

    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaCorredera");
        structBESA.bindGuard("GuardaCorredera", MaritimeLogAgentGuard.class);
        return structBESA;
    }

    private static MaritimeLogAgentState createState() throws ExceptionBESA {
        return new MaritimeLogAgentState();
    }
    
    
    @Override
    public void setupAgent() {
        try {
            AdmBESA.getInstance().getHandlerByAlias("MaritimeLog").sendEvent(
                new EventBESA(
                    MaritimeLogAgentGuard.class.getName(),
                    new PeriodicDataBESA(
                        1000,
                        PeriodicGuardBESA.START_PERIODIC_CALL
                    )
                )
            );
        } catch (ExceptionBESA e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void shutdownAgent() {
    }
}
