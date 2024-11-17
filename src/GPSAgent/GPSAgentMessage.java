package GPSAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.System.AdmBESA;

public class GPSAgentMessage extends DataBESA {
    
    // Variables for data reading
    private String contenido;
    private List<String> data = new ArrayList<>();
    private int index;

    private GPSAgentState gpsAgentState;
        
    public void readData() {
        String csvFile = "src/GPSAgent/GPSData.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                this.data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GPSAgentMessage(GPSAgentState state) {
        this.gpsAgentState = state;
        readData();
        setContent();
    }

    public String getContent() {
        return this.contenido;
    }

    public void setContent() {
        this.index = gpsAgentState.getIndex();
        if (this.index == this.data.size()-1){
            gpsAgentState.restartIndex();
        }
        this.contenido = this.data.get(this.index);
        gpsAgentState.increaseIndex();
        try {
            GPSAgentState gpsState = (GPSAgentState) AdmBESA.getInstance().getHandlerByAlias("GPS").getAg().getState();
            gpsState.setContent(this.contenido);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}