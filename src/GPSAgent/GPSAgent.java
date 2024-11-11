package GPSAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Util.PeriodicDataBESA;

public class GPSAgent extends AgentBESA{
    public GPSAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }

    public static GPSAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new GPSAgent(
            alias,
            createState(),
            createStruct(new StructBESA()),
            passwd
        );
    }

    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaGPS");
        structBESA.bindGuard("GuardaGPS", GPSAgentGuard.class);
        return structBESA;
    }

    private static GPSAgentState createState() throws ExceptionBESA {
        return new GPSAgentState();
    }

    @Override
    public void setupAgent() {
        try {
            AdmBESA.getInstance().getHandlerByAlias("GPS").sendEvent(
                new EventBESA(
                    GPSAgentGuard.class.getName(),
                    new PeriodicDataBESA(
                        1000,
                        PeriodicGuardBESA.START_PERIODIC_CALL
                    )
                )
            );
        } catch (ExceptionBESA e) {
            throw new RuntimeException(e);
        }
        GPSAgentMessage.readData();
    }

    @Override
    public void shutdownAgent() {
    }
}
