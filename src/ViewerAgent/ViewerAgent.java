package ViewerAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Util.PeriodicDataBESA;

public class ViewerAgent extends AgentBESA{
    public ViewerAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }

    public static ViewerAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new ViewerAgent(
            alias,
            createState(),
            createStruct(new StructBESA()),
            passwd
        );
    }

    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaViewer");
        structBESA.bindGuard("GuardaViewer", ViewerAgentGuard.class);
        return structBESA;
    }

    private static ViewerAgentState createState() throws ExceptionBESA {
        return new ViewerAgentState();
    }

    @Override
    public void setupAgent() {
        try {
            AdmBESA.getInstance().getHandlerByAlias("Viewer").sendEvent(
                new EventBESA(
                    ViewerAgentGuard.class.getName(),
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
