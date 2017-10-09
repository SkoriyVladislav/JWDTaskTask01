package by.tc.task01.entity;

public class VacuumCleaner extends Appliance{
	// you may add your own code here

    private double powerConsumption, motorSpeedRegulation, cleaningWidth;
    private String filterType, bagType, wandType;

    public VacuumCleaner() {

    }

    public VacuumCleaner(double powerConsumption, double motorSpeedRegulation, double cleaningWidth, String filterType, String bagType, String wandType) {
        this.powerConsumption = powerConsumption;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacuumCleaner that = (VacuumCleaner) o;

        if (Double.compare(that.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(that.motorSpeedRegulation, motorSpeedRegulation) != 0) return false;
        if (Double.compare(that.cleaningWidth, cleaningWidth) != 0) return false;
        if (filterType != null ? !filterType.equals(that.filterType) : that.filterType != null) return false;
        if (bagType != null ? !bagType.equals(that.bagType) : that.bagType != null) return false;
        return wandType != null ? wandType.equals(that.wandType) : that.wandType == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(powerConsumption);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(motorSpeedRegulation);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cleaningWidth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (filterType != null ? filterType.hashCode() : 0);
        result = 31 * result + (bagType != null ? bagType.hashCode() : 0);
        result = 31 * result + (wandType != null ? wandType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "powerConsumption=" + powerConsumption +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                ", filterType='" + filterType + '\'' +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                '}';
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }
}
