package GyroAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.Kernel.Agent.Event.DataBESA;

public class GyroAgentMessage extends DataBESA {
    
    private String contenido;
    private static List<String> data = new ArrayList<>();
    private int index;
        
    public static void readData(String[] args) {
        String csvFile = "src/GyroAgent/GyroData.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GyroAgentMessage() {
    }

    public String getContenido() {
        index = GyroAgentState.getIndex();
        setContenido(data.get(index));
        if (index == data.size()-1){
            GyroAgentState.restartIndex();
            return contenido;
        }
        GyroAgentState.increaseIndex();
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}