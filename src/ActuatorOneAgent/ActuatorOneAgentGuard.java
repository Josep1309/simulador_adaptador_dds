package ActuatorOneAgent;

import BESA.Kernel.Agent.Event.EventBESA;
import TranslatorAgent.TranslatorAgentGPSMessage;
import TranslatorAgent.TranslatorAgentGyroMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BESA.Kernel.Agent.GuardBESA;

public class ActuatorOneAgentGuard extends GuardBESA {

    @Override
    public void funcExecGuard(EventBESA event) {
        Object data = event.getData();
        ActuatorOneAgentState actuadorOneState = (ActuatorOneAgentState) this.getAgent().getState();

        if (data instanceof TranslatorAgentGPSMessage) {
            TranslatorAgentGPSMessage gpsData = (TranslatorAgentGPSMessage) data;
            // Parse data to variables to create a GUI
            // Patterns for each value
            Pattern latitudePattern = Pattern.compile("<Latitude>\\s*<Value>([\\d.]+)</Value>\\s*<Direction>(\\w+)</Direction>");
            Pattern longitudePattern = Pattern.compile("<Longitude>\\s*<Value>([\\d.]+)</Value>\\s*<Direction>(\\w+)</Direction>");
            Pattern satellitesPattern = Pattern.compile("<Satellites>\\s*<Number>(\\d+)</Number>");
            Pattern altitudePattern = Pattern.compile("<Altitude>\\s*<Value>([\\d.]+)</Value>\\s*<Units>(\\w+)</Units>");

            // Match each pattern
            Matcher latitudeMatcher = latitudePattern.matcher(gpsData.getContent());
            Matcher longitudeMatcher = longitudePattern.matcher(gpsData.getContent());
            Matcher satellitesMatcher = satellitesPattern.matcher(gpsData.getContent());
            Matcher altitudeMatcher = altitudePattern.matcher(gpsData.getContent());

            // Pass data to state function to show in console
            if (latitudeMatcher.find()) {
                actuadorOneState.setLatitude(Double.parseDouble(latitudeMatcher.group(1)));
                actuadorOneState.setLatitudeDirection(latitudeMatcher.group(2));
            }
    
            if (longitudeMatcher.find()) {
                actuadorOneState.setLongitude(Double.parseDouble(longitudeMatcher.group(1)));
                actuadorOneState.setLongitudeDirection(longitudeMatcher.group(2));
            }
    
            if (satellitesMatcher.find()) {
                actuadorOneState.setNumberOfSatellites(Integer.parseInt(satellitesMatcher.group(1)));
            }
    
            if (altitudeMatcher.find()) {
                actuadorOneState.setAltitude(Double.parseDouble(altitudeMatcher.group(1)));
                actuadorOneState.setAltitudeUnits(altitudeMatcher.group(2));
            }
            //System.out.println(gpsData.getContent());
        } else if (data instanceof TranslatorAgentGyroMessage) {
            TranslatorAgentGyroMessage gyroData = (TranslatorAgentGyroMessage) data;
            // Parse data to variables to create a GUI
            // Patterns for each value
            Pattern headingPattern = Pattern.compile("<MagneticHeading>\\s*<Value>([\\d.]+)</Value>");
            Pattern deviationPattern = Pattern.compile("<MagneticDeviation>\\s*<Value>([\\d.]+)</Value>\\s*<Direction>(\\w+)</Direction>");
            Pattern variationPattern = Pattern.compile("<MagneticVariation>\\s*<Value>([\\d.]+)</Value>\\s*<Direction>(\\w+)</Direction>");

            // Match each pattern
            Matcher headingMatcher = headingPattern.matcher(gyroData.getContent());
            Matcher deviationMatcher = deviationPattern.matcher(gyroData.getContent());
            Matcher variationMatcher = variationPattern.matcher(gyroData.getContent());
            
            // Pass data to state function to show in console
            if (headingMatcher.find()) {
                actuadorOneState.setMagneticHeading(Double.parseDouble(headingMatcher.group(1)));
            }
    
            if (deviationMatcher.find()) {
                actuadorOneState.setMagneticDeviation(Double.parseDouble(deviationMatcher.group(1)));
                actuadorOneState.setDeviationDirection(deviationMatcher.group(2));
            }
    
            if (variationMatcher.find()) {
                actuadorOneState.setMagneticVariation(Double.parseDouble(variationMatcher.group(1)));
                actuadorOneState.setVariationDirection(variationMatcher.group(2));
            }
            //System.out.println(gyroData.getContent());
        }
    }
}