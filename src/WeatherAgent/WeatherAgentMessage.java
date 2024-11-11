package WeatherAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.Kernel.Agent.Event.DataBESA;

public class WeatherAgentMessage extends DataBESA {
    
    private static String contenido;
    private static List<String> data = new ArrayList<>();
    private static int index;
        
    public static void readData() {
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
        setContent();
    }

    public String getContent() {
        return contenido;
    }

    public static void setContent() {
        index = WeatherAgentState.getIndex();
        if (index == data.size()-1){
            WeatherAgentState.restartIndex();
        }
        contenido = data.get(index);
        WeatherAgentState.increaseIndex();
    }
}