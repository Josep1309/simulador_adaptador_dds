package GyroAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Util.PeriodicDataBESA;

public class GyroAgent extends AgentBESA{
    public GyroAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }
    
    public static GyroAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new GyroAgent(
                alias,
                createState(),
                createStruct(
                        new StructBESA()
                ),
                passwd
        );
    }

    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaGyro");
        structBESA.bindGuard("GuardaGyro", GyroAgentGuard.class);
        return structBESA;
    }

    private static GyroAgentState createState() throws ExceptionBESA {
        return new GyroAgentState();
    }
    
    
    @Override
    public void setupAgent() {
        try {
            AdmBESA.getInstance().getHandlerByAlias("Gyro").sendEvent(
                new EventBESA(
                    GyroAgentGuard.class.getName(),
                    new PeriodicDataBESA(
                        5000,
                        PeriodicGuardBESA.START_PERIODIC_CALL
                    )
                )
            );
        } catch (ExceptionBESA e) {
            throw new RuntimeException(e);
        }
        GyroAgentMessage.readData();
    }

    @Override
    public void shutdownAgent() {
    }
}