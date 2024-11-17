package ActuatorTwoAgent;

import BESA.Kernel.Agent.Event.EventBESA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BESA.Kernel.Agent.GuardBESA;
import TranslatorAgent.TranslatorAgentWeatherMessage;

public class ActuatorTwoAgentGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        Object data = event.getData();
        ActuatorTwoAgentState actuatorTwoAgentState = (ActuatorTwoAgentState) this.getAgent().getState();

        if (data instanceof TranslatorAgentWeatherMessage) {
            TranslatorAgentWeatherMessage weatherData = (TranslatorAgentWeatherMessage) data;
            // Parse data to variables to create a GUI
            // Patterns for each value
            Pattern trueWindDirectionPattern = Pattern.compile("<TrueWindDirection>\\s*<Value>([\\d.]+)</Value>");
            Pattern magneticWindDirectionPattern = Pattern.compile("<MagneticWindDirection>\\s*<Value>([\\d.]+)</Value>");
            Pattern windSpeedKnotsPattern = Pattern.compile("<Knots>([\\d.]+)</Knots>");
            Pattern windSpeedMetersPerSecondPattern = Pattern.compile("<MetersPerSecond>([\\d.]+)</MetersPerSecond>");

            // Match each pattern
            Matcher trueWindDirectionMatcher = trueWindDirectionPattern.matcher(weatherData.getContent());
            Matcher magneticWindDirectionMatcher = magneticWindDirectionPattern.matcher(weatherData.getContent());
            Matcher windSpeedKnotsMatcher = windSpeedKnotsPattern.matcher(weatherData.getContent());
            Matcher windSpeedMetersPerSecondMatcher = windSpeedMetersPerSecondPattern.matcher(weatherData.getContent());

            if (trueWindDirectionMatcher.find()) {
                actuatorTwoAgentState.setTrueWindDirection(Double.parseDouble(trueWindDirectionMatcher.group(1)));
            }
    
            if (magneticWindDirectionMatcher.find()) {
                actuatorTwoAgentState.setMagneticWindDirection(Double.parseDouble(magneticWindDirectionMatcher.group(1)));
            }
    
            if (windSpeedKnotsMatcher.find()) {
                actuatorTwoAgentState.setWindSpeedKnots(Double.parseDouble(windSpeedKnotsMatcher.group(1)));
            }
    
            if (windSpeedMetersPerSecondMatcher.find()) {
                actuatorTwoAgentState.setWindSpeedMetersPerSecond(Double.parseDouble(windSpeedMetersPerSecondMatcher.group(1)));
            }
        }
    }
}