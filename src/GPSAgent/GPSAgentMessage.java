package GPSAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.Kernel.Agent.Event.DataBESA;

public class GPSAgentMessage extends DataBESA {
    
    // Variables for data reading
    private static String contenido;
    private static List<String> data = new ArrayList<>();
    private static int index;
        
    public static void readData() {
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
        setContent();
    }

    public String getContent() {
        return contenido;
    }

    public static void setContent() {
        index = GPSAgentState.getIndex();
        if (index == data.size()-1){
            GPSAgentState.restartIndex();
        }
        contenido = data.get(index);
        GPSAgentState.increaseIndex();
    }   
}