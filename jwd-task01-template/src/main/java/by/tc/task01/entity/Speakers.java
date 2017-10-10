package by.tc.task01.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Speakers extends Appliance{
	// you may add your own code here

    private double powerConsumption, numberOfSpeakers, cordLength;
    private String frequencyRange;

    public Speakers() {

    }

    public Speakers(double powerConsumption, double numberOfSpeakers, String frequencyRange, double cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public static Appliance create(String line) {
        Appliance appliance;

        Pattern pat = Pattern.compile("POWER_CONSUMPTION=[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(line);
        matcher.find();
        double  powerConsumption = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("NUMBER_OF_SPEAKERS=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double numberOfSpeakers = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("FREQUENCY_RANGE=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        String frequencyRange = matcher.group().substring("FREQUENCY_RANGE=".length());

        pat = Pattern.compile("CORD_LENGTH=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double cordLength = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        appliance = new Speakers(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);

        return appliance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speakers speakers = (Speakers) o;

        if (Double.compare(speakers.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(speakers.numberOfSpeakers, numberOfSpeakers) != 0) return false;
        if (Double.compare(speakers.cordLength, cordLength) != 0) return false;
        return frequencyRange != null ? frequencyRange.equals(speakers.frequencyRange) : speakers.frequencyRange == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(powerConsumption);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(numberOfSpeakers);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cordLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (frequencyRange != null ? frequencyRange.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange=" + frequencyRange +
                ", cordLength=" + cordLength +
                '}';
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(double numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }
}
