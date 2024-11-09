package GPSAgent;

import BESA.Kernel.Agent.StateBESA;

class GPSAgentState extends StateBESA{

    private static int index = 0;
    
    public GPSAgentState() {
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