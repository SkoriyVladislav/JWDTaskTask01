package by.tc.task01.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Refrigerator extends Appliance{
	// you may add your own code here
    private double powerConsumption, weight, freezerCapacity, overallCapacity, height, width;

    public Refrigerator() {

    }

    public Refrigerator(double powerConsumption, double weight, double freezerCapacity, double overallCapacity, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    public static Appliance create(String line) {
        Appliance appliance;

        Pattern pat = Pattern.compile("POWER_CONSUMPTION=[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(line);
        matcher.find();
        double  powerConsumption = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("WEIGHT=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double weight = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("FREEZER_CAPACITY=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double freezerCapacity = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("OVERALL_CAPACITY=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double overallCapacity = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("HEIGHT=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double height = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("WIDTH=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double width = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        appliance = new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);

        return appliance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Refrigerator that = (Refrigerator) o;

        if (Double.compare(that.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (Double.compare(that.freezerCapacity, freezerCapacity) != 0) return false;
        if (Double.compare(that.overallCapacity, overallCapacity) != 0) return false;
        if (Double.compare(that.height, height) != 0) return false;
        return Double.compare(that.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(powerConsumption);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(freezerCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(overallCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
