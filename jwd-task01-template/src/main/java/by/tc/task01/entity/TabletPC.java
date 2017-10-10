package by.tc.task01.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TabletPC extends Appliance{
	// you may add your own code here

    private double batteryCapacity, displayInches, memoryROM, flashMemoryCapacity;
    private String color;

    public TabletPC() {

    }

    public TabletPC(double batteryCapacity, double displayInches, double memoryROM, double flashMemoryCapacity, String color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryROM = memoryROM;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public static Appliance create(String line) {
        Appliance appliance;

        Pattern pat = Pattern.compile("BATTERY_CAPACITY=[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(line);
        matcher.find();
        double  batteryCapacity = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("DISPLAY_INCHES=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double displayInches = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("MEMORY_ROM=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double memoryRom = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("FLASH_MEMORY_CAPACITY=[0-9]+(.[0-9]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        double flashMemoryCapacity = Double.valueOf(matcher.group().replaceAll("([a-z]|[A-Z]|=|_)", " ").trim());

        pat = Pattern.compile("COLOR=[a-z|A-Z]+(.[a-z|A-z]+)?");
        matcher = pat.matcher(line);
        matcher.find();
        String color = matcher.group().substring("COLOR=".length());

        appliance = new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);

        return appliance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (Double.compare(tabletPC.batteryCapacity, batteryCapacity) != 0) return false;
        if (Double.compare(tabletPC.displayInches, displayInches) != 0) return false;
        if (Double.compare(tabletPC.memoryROM, memoryROM) != 0) return false;
        if (Double.compare(tabletPC.flashMemoryCapacity, flashMemoryCapacity) != 0) return false;
        return color != null ? color.equals(tabletPC.color) : tabletPC.color == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(memoryROM);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(flashMemoryCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryROM=" + memoryROM +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
