package GyroAgent;

import BESA.Kernel.Agent.StateBESA;

public class GyroAgentState extends StateBESA{
    
    private int index = 0;
    private String contenido;

    public GyroAgentState() {
    }

    public int getIndex() {
        return index;
    }

    public void increaseIndex() {
        index++;
    }

    public void restartIndex(){
        index = 0;
    }

    public void setContent(String content){
        contenido = content;
    }
    
    public String getContent(){
        return contenido;
    }
}