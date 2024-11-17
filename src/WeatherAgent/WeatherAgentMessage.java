package WeatherAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.System.AdmBESA;

public class WeatherAgentMessage extends DataBESA {
    
    private String contenido;
    private List<String> data = new ArrayList<>();
    private int index;
    private WeatherAgentState weatherState;
        
    public void readData() {
        String csvFile = "src/WeatherAgent/WeatherData.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                this.data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WeatherAgentMessage(WeatherAgentState weatherState) {
        this.weatherState = weatherState;
        readData();
        setContent();
    }

    public String getContent() {
        return this.contenido;
    }

    public void setContent() {
        this.index = weatherState.getIndex();
        if (this.index == this.data.size()-1){
            weatherState.restartIndex();
        }
        this.contenido = this.data.get(this.index);
        weatherState.increaseIndex();
        try {
            WeatherAgentState weatherState = (WeatherAgentState) AdmBESA.getInstance().getHandlerByAlias("Weather").getAg().getState();
            weatherState.setContent(this.contenido);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}