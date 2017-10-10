package by.tc.task01.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Laptop extends Appliance{
	// you may add your own code here
    private double batteryCapacity, memoryROM, systemMemory, CPU, displayInches;
    private String OS;

    public Laptop() {

    }

    public Laptop(double batteryCapacity, double memoryROM, double systemMemory, double CPU, double displayInches, String OS) {

        this.batteryCapacity = batteryCapacity;
        this.memoryROM = memoryROM;
        this.systemMemory = systemMemory;
        this.CPU = CPU;
        this.displayInches = displayInches;
        this.OS = OS;
    }

    public static Appliance create(String line) {
        Appliance appliance;

        Pattern pat = Pattern.compile("BATTERY_CAPACITY=[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(line);
        matcher.find();
        double  batteryCapacity= Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("MEMORY_ROM=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double memoryRom = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("SYSTEM_MEMORY=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double systemMemory = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("CPU=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double CPU = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("DISPLAY_INCHS=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double displayInchs = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("OS=[a-z|A-Z]+(.[a-z|A-z]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        String OS = matcher.group().substring(3);

        appliance = new Laptop(batteryCapacity, memoryRom, systemMemory, CPU, displayInchs, OS);

        return appliance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (Double.compare(laptop.batteryCapacity, batteryCapacity) != 0) return false;
        if (Double.compare(laptop.memoryROM, memoryROM) != 0) return false;
        if (Double.compare(laptop.systemMemory, systemMemory) != 0) return false;
        if (Double.compare(laptop.CPU, CPU) != 0) return false;
        if (Double.compare(laptop.displayInches, displayInches) != 0) return false;
        return OS != null ? OS.equals(laptop.OS) : laptop.OS == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(memoryROM);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(systemMemory);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(CPU);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (OS != null ? OS.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", memoryROM=" + memoryROM +
                ", systemMemory=" + systemMemory +
                ", CPU=" + CPU +
                ", displayInches=" + displayInches +
                ", OS='" + OS + '\'' +
                '}';
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCPU() {
        return CPU;
    }

    public void setCPU(double CPU) {
        this.CPU = CPU;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }
}
