package GyroAgent;

import BESA.Kernel.Agent.StateBESA;

class GyroAgentState extends StateBESA{
    
    private static int index = 0;

    public GyroAgentState() {
    }

    public static int getIndex() {
        return index;
    }

    public static void increaseIndex() {
        index++;
    }

    public static void restartIndex(){
        index = 0;
    }
    
}