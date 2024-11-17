package ViewerAgent;

import BESA.Kernel.Agent.StateBESA;

public class ViewerAgentState extends StateBESA{
    // Variables for GPS data
    private double latitude;
    private String latitudeDirection;
    private double longitude;
    private String longitudeDirection;
    private int numberOfSatellites;
    private double altitude;
    private String altitudeUnits;

    // Variables for Magnetic data
    private double magneticHeading;
    private double magneticDeviation;
    private String deviationDirection;
    private double magneticVariation;
    private String variationDirection;

    // Variables for Wind data
    private double trueWindDirection;
    private double magneticWindDirection;
    private double windSpeedKnots;
    private double windSpeedMetersPerSecond;

    // Constructor
    public ViewerAgentState() {
    }

    // Getters and setters for GPS data
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLatitudeDirection() {
        return latitudeDirection;
    }

    public void setLatitudeDirection(String latitudeDirection) {
        this.latitudeDirection = latitudeDirection;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLongitudeDirection() {
        return longitudeDirection;
    }

    public void setLongitudeDirection(String longitudeDirection) {
        this.longitudeDirection = longitudeDirection;
    }

    public int getNumberOfSatellites() {
        return numberOfSatellites;
    }

    public void setNumberOfSatellites(int numberOfSatellites) {
        this.numberOfSatellites = numberOfSatellites;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getAltitudeUnits() {
        return altitudeUnits;
    }

    public void setAltitudeUnits(String altitudeUnits) {
        this.altitudeUnits = altitudeUnits;
    }

    // Getters and setters for Magnetic data
    public double getMagneticHeading() {
        return magneticHeading;
    }

    public void setMagneticHeading(double magneticHeading) {
        this.magneticHeading = magneticHeading;
    }

    public double getMagneticDeviation() {
        return magneticDeviation;
    }

    public void setMagneticDeviation(double magneticDeviation) {
        this.magneticDeviation = magneticDeviation;
    }

    public String getDeviationDirection() {
        return deviationDirection;
    }

    public void setDeviationDirection(String deviationDirection) {
        this.deviationDirection = deviationDirection;
    }

    public double getMagneticVariation() {
        return magneticVariation;
    }

    public void setMagneticVariation(double magneticVariation) {
        this.magneticVariation = magneticVariation;
    }

    public String getVariationDirection() {
        return variationDirection;
    }

    public void setVariationDirection(String variationDirection) {
        this.variationDirection = variationDirection;
    }

    // Getters and setters for Wind data
    public double getTrueWindDirection() {
        return trueWindDirection;
    }

    public void setTrueWindDirection(double trueWindDirection) {
        this.trueWindDirection = trueWindDirection;
    }

    public double getMagneticWindDirection() {
        return magneticWindDirection;
    }

    public void setMagneticWindDirection(double magneticWindDirection) {
        this.magneticWindDirection = magneticWindDirection;
    }

    public double getWindSpeedKnots() {
        return windSpeedKnots;
    }

    public void setWindSpeedKnots(double windSpeedKnots) {
        this.windSpeedKnots = windSpeedKnots;
    }

    public double getWindSpeedMetersPerSecond() {
        return windSpeedMetersPerSecond;
    }

    public void setWindSpeedMetersPerSecond(double windSpeedMetersPerSecond) {
        this.windSpeedMetersPerSecond = windSpeedMetersPerSecond;
    }
}
