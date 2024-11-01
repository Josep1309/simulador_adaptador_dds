package ActuatorOneAgent;

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
public class ActuatorOneAgentGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA ebesa) {
        System.out.println("Llegó a la Guarda del Vendedor");
        try {
            AdmBESA.getInstance().getHandlerByAlias("comprador").sendEvent(new EventBESA(
                            null
                    )        
            );
            Thread.sleep(1000);
        } catch (ExceptionBESA ex) {
            System.err.println(ex.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(ActuatorOneAgentGuard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}