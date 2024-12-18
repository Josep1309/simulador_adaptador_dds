package TranslatorAgent;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.AgentBESA;
import BESA.Kernel.Agent.KernelAgentExceptionBESA;
import BESA.Kernel.Agent.StateBESA;
import BESA.Kernel.Agent.StructBESA;

public class TranslatorAgent extends AgentBESA{
    public TranslatorAgent(String alias, StateBESA state, StructBESA structAgent, double passwd) throws KernelAgentExceptionBESA {
        super(alias, state, structAgent, passwd);
    }

    public static TranslatorAgent createAgent(String alias) throws ExceptionBESA {
        double passwd = 0.99;
        return new TranslatorAgent(
                alias,
                createState(),
                createStruct(
                        new StructBESA()
                ),
                passwd
        );
    }

    private static StructBESA createStruct(StructBESA structBESA) throws ExceptionBESA {
        structBESA.addBehavior("GuardaTranslator");
        structBESA.bindGuard("GuardaTranslator", TranslatorAgentGuard.class);
        return structBESA;
    }

    private static TranslatorAgentState createState() throws ExceptionBESA {
        return new TranslatorAgentState();
    }
    
    @Override
    public void setupAgent() {
    }

    @Override
    public void shutdownAgent() {
    }
}
