package GyroAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.Kernel.Agent.Event.DataBESA;

public class GyroAgentMessage extends DataBESA {
    
    private static String contenido;
    private static List<String> data = new ArrayList<>();
    private static int index;
        
    public static void readData() {
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
        setContent();
    }

    public String getContent() {
        return contenido;
    }

    public static void setContent() {
        index = GyroAgentState.getIndex();
        if (index == data.size()-1){
            GyroAgentState.restartIndex();
        }
        contenido = data.get(index);
        GyroAgentState.increaseIndex();
    }
}