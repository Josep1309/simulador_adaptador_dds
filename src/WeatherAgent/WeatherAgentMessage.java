package WeatherAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.Kernel.Agent.Event.DataBESA;

public class WeatherAgentMessage extends DataBESA {
    
    private String contenido;
    private static List<String> data = new ArrayList<>();
    private int index;
        
    public static void readData(String[] args) {
        String csvFile = "src/WeatherAgent/WeatherData.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WeatherAgentMessage() {
    }

    public String getContenido() {
        index = WeatherAgentState.getIndex();
        setContenido(data.get(index));
        if (index == data.size()-1){
            WeatherAgentState.restartIndex();
            return contenido;
        }
        WeatherAgentState.increaseIndex();
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}