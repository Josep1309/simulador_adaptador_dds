package TranslatorAgent;

import BESA.Kernel.Agent.Event.DataBESA;

public class TranslatorAgentParsing extends DataBESA{

    public static String gpsToXML(String data){
        String parseData;
        String[] parts = data.split(",");

        double latitude = Double.parseDouble(parts[2]);
        String latitudeDirection = parts[3];
        double longitude = Double.parseDouble(parts[4]);
        String longitudeDirection = parts[5];
        int numberOfSatellites = Integer.parseInt(parts[7]);
        double altitude = Double.parseDouble(parts[9]);
        String altitudeUnits = parts[10];

        parseData = String.format("""
            <GPSData>
                <Location>
                    <Latitude>
                        <Value>%.4f</Value>
                        <Direction>%s</Direction>
                    </Latitude>
                    <Longitude>
                        <Value>%.4f</Value>
                        <Direction>%s</Direction>
                    </Longitude>
                </Location>
                <Satellites>
                    <Number>%d</Number>
                </Satellites>
                <Altitude>
                    <Value>%.1f</Value>
                    <Units>%s</Units>
                </Altitude>
            </GPSData>
            """, latitude, latitudeDirection, longitude, longitudeDirection, numberOfSatellites, altitude, altitudeUnits);

        return parseData;
    }

    public static String GyroToXML(String data){
        String parseData;
        String[] parts = data.split(",");

        double magneticHeading = Double.parseDouble(parts[1]);
        double magneticDeviation = Double.parseDouble(parts[2]);
        String deviationDirection = parts[3];
        double magneticVariation = Double.parseDouble(parts[4]);
        String variationDirection = parts[5].split("\\*")[0];

        parseData = String.format("""
            <MagneticData>
                <MagneticHeading>
                    <Value>%.1f</Value>
                </MagneticHeading>
                <MagneticDeviation>
                    <Value>%.1f</Value>
                    <Direction>%s</Direction>
                </MagneticDeviation>
                <MagneticVariation>
                    <Value>%.1f</Value>
                    <Direction>%s</Direction>
                </MagneticVariation>
            </MagneticData>
            """, magneticHeading, magneticDeviation, deviationDirection, magneticVariation, variationDirection);

        return parseData;
    }

    public static String WeatherToXML(String data){
        String parseData;
        String[] parts = data.split(",");

        double trueWindDirection = Double.parseDouble(parts[1]);
        double magneticWindDirection = Double.parseDouble(parts[3]);
        double windSpeedKnots = Double.parseDouble(parts[5]);
        double windSpeedMetersPerSecond = Double.parseDouble(parts[7]);

        parseData = String.format("""
            <WindData>
                <TrueWindDirection>
                    <Value>%.1f</Value>
                </TrueWindDirection>
                <MagneticWindDirection>
                    <Value>%.1f</Value>
                </MagneticWindDirection>
                <WindSpeed>
                    <Knots>%.1f</Knots>
                    <MetersPerSecond>%.1f</MetersPerSecond>
                </WindSpeed>
            </WindData>
            """, trueWindDirection, magneticWindDirection, windSpeedKnots, windSpeedMetersPerSecond);

        return parseData;
    }
}
