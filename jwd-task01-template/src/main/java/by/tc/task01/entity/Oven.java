package by.tc.task01.entity;

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
}
