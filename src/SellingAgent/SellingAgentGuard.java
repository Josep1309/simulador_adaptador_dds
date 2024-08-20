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

import BuyerAgent.BuyerAgentGuard;
import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.System.AdmBESA;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The HelloWorldGuard class is a guard that handles events sent to the HelloWorldAgent.
 * When an event is received, it logs a message to the console and reports a "Hello World" message
 * using the BESA logging system.
 * 
 * @author Jairo Serrano
 * @version 1.0
 * @since 2024
 */
public class SellingAgentGuard extends GuardBESA {

    /**
     * This method is executed when the guard receives an event. It logs a message indicating 
     * that information has arrived at the guard, and then it reports a "Hello World" message.
     *
     * @param ebesa The event received by the guard.
     */
    @Override
    public void funcExecGuard(EventBESA ebesa) {
        System.out.println("Llegó a la Guarda del Comprador");
        try {
            AdmBESA.getInstance().getHandlerByAlias("vendedor").sendEvent(new EventBESA(
                            BuyerAgentGuard.class.getName(),
                            null
                    )        
            );
            Thread.sleep(1500);
        } catch (ExceptionBESA ex) {
            System.err.println(ex.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(SellingAgentGuard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
