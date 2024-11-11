package WeatherAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.PeriodicGuardBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;
import BESA.Kernel.Agent.Event.EventBESA;
import BESA.Kernel.System.AdmBESA;
import BESA.Util.PeriodicDataBESA;

public class WeatherAgent extends AgentBESA{
    public WeatherAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }
    
    public static WeatherAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new WeatherAgent(
                alias,
                createState(),
                createStruct(
                        new StructBESA()
                ),
                passwd
        );
    }

    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaWeather");
        structBESA.bindGuard("GuardaWeather", WeatherAgentGuard.class);
        return structBESA;
    }

    private static WeatherAgentState createState() throws ExceptionBESA {
        return new WeatherAgentState();
    }
    
    @Override
    public void setupAgent() {
        try {
            AdmBESA.getInstance().getHandlerByAlias("Weather").sendEvent(
                new EventBESA(
                    WeatherAgentGuard.class.getName(),
                    new PeriodicDataBESA(
                        1000,
                        PeriodicGuardBESA.START_PERIODIC_CALL
                    )
                )
            );
        } catch (ExceptionBESA e) {
            throw new RuntimeException(e);
        }
        WeatherAgentMessage.readData();
    }

    @Override
    public void shutdownAgent() {
    }
}
