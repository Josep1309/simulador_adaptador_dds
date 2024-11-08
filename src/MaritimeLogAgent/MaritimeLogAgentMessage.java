package MaritimeLogAgent;

import BESA.Kernel.Agent.Event.DataBESA;

public class MaritimeLogAgentMessage extends DataBESA {
    
    private String contenido;

    public MaritimeLogAgentMessage(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}