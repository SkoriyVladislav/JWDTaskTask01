package by.tc.task01.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Oven extends Appliance{
	// you may add your own code here
    private double powerConsumption, weight, capacity, depth, height, width;

    public Oven() {

    }

    public Oven(double powerConsumption, double weight, double capacity, double depth, double height, double width) {
        super();
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public static Appliance create(String line) {
        Appliance appliance;

        Pattern pat = Pattern.compile("POWER_CONSUMPTION=[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(line);
        matcher.find();
        double powerConsumption = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

        pat = Pattern.compile("WEIGHT=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double weight = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

        pat = Pattern.compile("CAPACITY=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double capasity = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

        pat = Pattern.compile("DEPTH=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double depth = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

        pat = Pattern.compile("WIDTH=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double width = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

        pat = Pattern.compile("HEIGHT=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double height = Double.valueOf(matcher.group().replaceAll("\\D+", " ").trim());

        appliance = new Oven(powerConsumption, weight, capasity, depth, height, width);

        return appliance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oven oven = (Oven) o;

        if (Double.compare(oven.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(oven.weight, weight) != 0) return false;
        if (Double.compare(oven.capacity, capacity) != 0) return false;
        if (Double.compare(oven.depth, depth) != 0) return false;
        if (Double.compare(oven.height, height) != 0) return false;
        return Double.compare(oven.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(powerConsumption);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(capacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Oven{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
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

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
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
