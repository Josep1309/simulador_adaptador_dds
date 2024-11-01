package GyroAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;

public class GyroAgent extends AgentBESA{
    public GyroAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }
    
    /**
     * Factory method to create an instance of HelloWorldAgent.
     * This method initializes the agent's state, structure, and password.
     *
     * @param alias The alias of the agent.
     * @return A new instance of HelloWorldAAgent.
     * @throws ExceptionBESA If an error occurs during agent creation.
     */
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

    /**
     * Creates the structure for the HelloWorldAgent.
     * This method adds the "HelloWorldGuard" behavior and binds it to the HelloWorldGuard class.
     *
     * @param structBESA The structure object to be configured.
     * @return The configured structure object.
     * @throws ExceptionBESA If an error occurs during structure creation.
     */
    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaGPS");
        structBESA.bindGuard("GuardaGPS", GyroAgentGuard.class);
        return structBESA;
    }

    /**
     * Creates the state for the HelloWorldAgent.
     * This method returns a new instance of HelloWorldState.
     *
     * @return A new instance of HelloWorldAState.
     * @throws ExceptionBESA If an error occurs during state creation.
     */
    private static GyroAgentState createState() throws ExceptionBESA {
        return new GyroAgentState();
    }
    
    
    @Override
    public void setupAgent() {
    }

    @Override
    public void shutdownAgent() {
    }
}