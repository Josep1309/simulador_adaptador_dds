package GyroAgent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BESA.ExceptionBESA;
import BESA.Kernel.Agent.Event.DataBESA;
import BESA.Kernel.System.AdmBESA;

public class GyroAgentMessage extends DataBESA {
    
    private String contenido;
    private List<String> data = new ArrayList<>();
    private int index;

    private GyroAgentState gyroState;
        
    public void readData() {
        String csvFile = "src/GyroAgent/GyroData.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                this.data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GyroAgentMessage(GyroAgentState gyroState) {
        this.gyroState = gyroState;
        readData();
        setContent();
    }

    public String getContent() {
        return this.contenido;
    }

    public void setContent() {
        this.index = gyroState.getIndex();
        if (this.index == this.data.size()-1){
            gyroState.restartIndex();
        }
        this.contenido = this.data.get(this.index);
        gyroState.increaseIndex();
        try {
            GyroAgentState gyroState = (GyroAgentState) AdmBESA.getInstance().getHandlerByAlias("Gyro").getAg().getState();
            gyroState.setContent(this.contenido);
        } catch (ExceptionBESA e) {
            e.printStackTrace();
        }
    }
}