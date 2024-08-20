package BuyerAgent;

import SellingAgent.SellingAgentGuard;
import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.Agent.GuardBESA;
import BESA.Kernel.System.AdmBESA;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class BuyerAgentGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        System.out.println("Llegó a la Guarda del Vendedor");
        try {
            AdmBESA.getInstance().getHandlerByAlias("comprador").sendEvent(new EventBESA(
                            SellingAgentGuard.class.getName(),
                            null
                    )        
            );
            Thread.sleep(1000);
        } catch (ExceptionBESA ex) {
            System.err.println(ex.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(BuyerAgentGuard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
