package WeatherAgent;

import BESA.Kernel.Agent.Event.DataBESA;

public class WeatherAgentMessage extends DataBESA {
    
    private String contenido;

    public WeatherAgentMessage(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}