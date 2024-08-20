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

import BESA.Kernel.Agent.StateBESA;
import java.io.Serializable;

/**
 * The HelloWorldState class represents the state of the HelloWorldAgent.
 * This class extends the StateBESA class, allowing it to hold the internal state
 * of the agent, which can be shared and manipulated by different guards.
 * 
 * @author Jairo Serrano
 * @version 1.0
 * @since 2024
 */
public class SellingAgentState extends StateBESA implements Serializable {

    /**
     * Default constructor for HelloWorldState.
     * Currently, it does not initialize any specific state variables.
     */
    public SellingAgentState() {
        // Default constructor.
    }
    
}
