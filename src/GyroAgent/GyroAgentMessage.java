package GyroAgent;

import BESA.Kernel.Agent.Event.DataBESA;

public class GyroAgentMessage extends DataBESA {
    
    private String contenido;

    public GyroAgentMessage(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}