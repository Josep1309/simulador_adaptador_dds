/**
 * ==========================================================================
 * HelloWordAgent                                                           *
 * @version 1.0                                                             *
 * @since 2024                                                              *
 * @author Jairo Serrano                                                    *
 * ==========================================================================
 * Hello World Agent for Testing.                                           *
 * ==========================================================================
 */

package SellingAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;

/**
 * The HelloWorldAgent class is a simple agent implementation using the BESA framework.
 * This agent is designed for testing purposes and demonstrates basic agent creation,
 * structure, and lifecycle management.
 * 
 * @author Jairo Serrano
 * @version 1.0
 * @since 2024
 */
public class SellingAgent extends AgentBESA {

    /**
     * Factory method to create an instance of HelloWorldAgent.
     * This method initializes the agent's state, structure, and password.
     *
     * @param alias The alias of the agent.
     * @return A new instance of SellingAgent.
     * @throws ExceptionBESA If an error occurs during agent creation.
     */
    public static SellingAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new SellingAgent(
                alias,
                createState(),
                createStruct(
                        new StructBESA()
                ),
                passwd
        );
    }

    /**
     * Constructor for HelloWorldAgent.
     * This constructor is used internally by the factory method to set up the agent
     * with its alias, state, structure, and password.
     *
     * @param alias The alias of the agent.
     * @param state The state of the agent.
     * @param structAgent The structure of the agent, defining its behaviors and guards.
     * @param passwd The password required for the agent's operations.
     * @throws KernelAgentExceptionBESA If an error occurs during the agent's kernel setup.
     */
    public SellingAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
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
        structBESA.addBehavior("GuardaComprador");
        structBESA.bindGuard("GuardaComprador", SellingAgentGuard.class);
        return structBESA;
    }

    /**
     * Creates the state for the HelloWorldAgent.
     * This method returns a new instance of HelloWorldState.
     *
     * @return A new instance of SellingAgentState.
     * @throws ExceptionBESA If an error occurs during state creation.
     */
    private static SellingAgentState createState() throws ExceptionBESA {
        return new SellingAgentState();
    }

    /**
     * This method is called when the agent is initialized.
     * It can be overridden to include setup tasks specific to the agent.
     */
    @Override
    public void setupAgent() {
    }

    /**
     * This method is called when the agent is shut down.
     * It can be overridden to include shutdown tasks specific to the agent.
     */
    @Override
    public void shutdownAgent() {
    }

}
