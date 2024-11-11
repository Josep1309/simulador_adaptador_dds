package TranslatorAgent;

import BESA.Kernel.Agent.Event.DataBESA;

public class TranslatorAgentWeatherMessage extends DataBESA {
    
    private String contenido;

    public TranslatorAgentWeatherMessage(String contenido) {
        this.contenido = contenido;
    }

    public String getContent() {
        return contenido;
    }

    public void setContent(String contenido) {
        this.contenido = contenido;
    }
}