package WeatherAgent;

import BESA.Kernel.Agent.StateBESA;

class WeatherAgentState extends StateBESA{

    private static int index = 0;
    
    public WeatherAgentState() {
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