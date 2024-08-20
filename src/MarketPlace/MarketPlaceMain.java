/**
 * ==========================================================================
 * MarketPlace                                                              *
 * @version 1.0                                                             *
 * @since 2024                                                              *
 * @author Jairo Serrano                                                    *
 * ==========================================================================
 * Hello World Agent for Testing.                                           *
 * ==========================================================================
 */

package MarketPlace;

import BESA.ExceptionBESA;
import BESA.Kernel.System.AdmBESA;
import SellingAgent.SellingAgent;
import SellingAgent.SellingAgentGuard;
import BuyerAgent.BuyerAgent;
import BESA.Kernel.Agent.Event.EventBESA;

/**
 * The HelloWorldMain class serves as the main entry point for the HelloWorld
 * example using the BESA framework. This class demonstrates the creation and
 * activation of a simple agent, followed by sending an event to that agent.
 * 
 * @author Jairo Serrano
 * @version 1.0
 * @since 2024
 */
public class MarketPlaceMain {

    /**
     * The main method is the entry point for the application.
     * It initializes the BESA system, creates a HelloWorldAgent, starts the agent,
     * and sends an event to the agent's guard.
     *
     * @param args Command line arguments.
     * @throws BESA.ExceptionBESA If there is an error initializing the BESA 
     *                            system or creating the agent.
     */
    public static void main(String[] args) throws ExceptionBESA {
        // Initialize the BESA administration system.
        AdmBESA admBesa = AdmBESA.getInstance();
        
        // Create a new SellingAgent with the alias "HolaMundo".
        SellingAgent sellingAgent = SellingAgent.createAgent("comprador");
        BuyerAgent buyerAgent = BuyerAgent.createAgent("vendedor");

        
        // Start the SellingAgent.
        buyerAgent.start();
        sellingAgent.start();
        
        // Retrieve the agent's handler by its alias and send an event to the SellingAgentGuard.
        admBesa.getHandlerByAlias("comprador").sendEvent(new EventBESA(
                        SellingAgentGuard.class.getName(), 
                        null
                )
        );
    }
    
}
