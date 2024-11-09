package GPSAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.Kernel.Agent.Event.DataBESA;

public class GPSAgentMessage extends DataBESA {
    
    private String contenido;
    private static List<String> data = new ArrayList<>();
    private int index;
        
    public static void readData(String[] args) {
        String csvFile = "src/GPSAgent/GPSData.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GPSAgentMessage() {
    }

    public String getContenido() {
        index = GPSAgentState.getIndex();
        setContenido(data.get(index));
        if (index == data.size()-1){
            GPSAgentState.restartIndex();
            return contenido;
        }
        GPSAgentState.increaseIndex();
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}