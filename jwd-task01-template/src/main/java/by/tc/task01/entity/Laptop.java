package by.tc.task01.entity;

public class Laptop extends Appliance{
	// you may add your own code here
    private double batteryCapacity, memoryRom, systemMemory, CPU, displayInchs;
    private String OS;

    public Laptop() {

    }

    public Laptop(double batteryCapacity, double memoryRom, double systemMemory, double CPU, double displayInchs, String OS) {

        this.batteryCapacity = batteryCapacity;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.CPU = CPU;
        this.displayInchs = displayInchs;
        this.OS = OS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (Double.compare(laptop.batteryCapacity, batteryCapacity) != 0) return false;
        if (Double.compare(laptop.memoryRom, memoryRom) != 0) return false;
        if (Double.compare(laptop.systemMemory, systemMemory) != 0) return false;
        if (Double.compare(laptop.CPU, CPU) != 0) return false;
        if (Double.compare(laptop.displayInchs, displayInchs) != 0) return false;
        return OS != null ? OS.equals(laptop.OS) : laptop.OS == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(memoryRom);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(systemMemory);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(CPU);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(displayInchs);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (OS != null ? OS.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", CPU=" + CPU +
                ", displayInchs=" + displayInchs +
                ", OS='" + OS + '\'' +
                '}';
    }
}
