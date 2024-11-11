package ActuatorOneAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;

public class ActuatorOneAgent extends AgentBESA{
    public ActuatorOneAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }
    
    public static ActuatorOneAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new ActuatorOneAgent(
                alias,
                createState(),
                createStruct(
                        new StructBESA()
                ),
                passwd
        );
    }

    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaOne");
        structBESA.bindGuard("GuardaOne", ActuatorOneAgentGuard.class);
        return structBESA;
    }

    private static ActuatorOneAgentState createState() throws ExceptionBESA {
        return new ActuatorOneAgentState();
    }
    
    @Override
    public void setupAgent() {
    }

    @Override
    public void shutdownAgent() {
    }
}
