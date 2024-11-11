package ActuatorTwoAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;

public class ActuatorTwoAgent extends AgentBESA{
    public ActuatorTwoAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }
    
    public static ActuatorTwoAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new ActuatorTwoAgent(
                alias,
                createState(),
                createStruct(
                        new StructBESA()
                ),
                passwd
        );
    }

    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaTwo");
        structBESA.bindGuard("GuardaTwo", ActuatorTwoAgentGuard.class);
        return structBESA;
    }

    private static ActuatorTwoAgentState createState() throws ExceptionBESA {
        return new ActuatorTwoAgentState();
    }
    
    @Override
    public void setupAgent() {
    }

    @Override
    public void shutdownAgent() {
    }
}
