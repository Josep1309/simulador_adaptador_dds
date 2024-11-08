package GPSAgent;

import BESA.Kernel.Agent.Event.DataBESA;

public class GPSAgentMessage extends DataBESA {
    
    private String contenido;

    public GPSAgentMessage(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}