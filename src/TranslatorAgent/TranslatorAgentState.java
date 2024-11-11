package TranslatorAgent;

import BESA.Kernel.Agent.StateBESA;

class TranslatorAgentState extends StateBESA{

    // GPS data
    private double latitude;
    private String latitudeDirection;
    private double longitude;
    private String longitudeDirection;
    private int numberOfSatellites;
    private double altitude;
    private String altitudeUnits;
    //private String timeUTC;
    //private int fixQuality;
    //private double hdop;
    //private double geoidalSeparation;
    //private String geoidalSeparationUnits;

    // Gyro data
    private double magneticHeading;
    private double magneticDeviation;
    private String deviationDirection;
    private double magneticVariation;
    private String variationDirection;

    // Weather data
    private double trueWindDirection;
    private double magneticWindDirection;
    private double windSpeedKnots;
    private double windSpeedMetersPerSecond;
    
    public TranslatorAgentState() {
    }

    public void setGPSData(double latitude, String latitudeDirection, double longitude, String longitudeDirection, int numberOfSatellites, double altitude, String altitudeUnits) {
        this.latitude = latitude;
        this.latitudeDirection = latitudeDirection;
        this.longitude = longitude;
        this.longitudeDirection = longitudeDirection;
        this.numberOfSatellites = numberOfSatellites;
        this.altitude = altitude;
        this.altitudeUnits = altitudeUnits;
    }

    public void setGyroData(double magneticHeading, double magneticDeviation, String deviationDirection, double magneticVariation, String variationDirection) {
        this.magneticHeading = magneticHeading;
        this.magneticDeviation = magneticDeviation;
        this.deviationDirection = deviationDirection;
        this.magneticVariation = magneticVariation;
        this.variationDirection = variationDirection;
    }

    public void setWeatherData(double trueWindDirection, double magneticWindDirection, double windSpeedKnots, double windSpeedMetersPerSecond) {
        this.trueWindDirection = trueWindDirection;
        this.magneticWindDirection = magneticWindDirection;
        this.windSpeedKnots = windSpeedKnots;
        this.windSpeedMetersPerSecond = windSpeedMetersPerSecond;
    }   
}

