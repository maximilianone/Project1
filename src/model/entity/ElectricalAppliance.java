package model.entity;

import java.io.Serializable;

public abstract class ElectricalAppliance implements Serializable{
    private String name;
    private String type;
    private double size;
    private double documentedPower;
    private double consumedPower;

    public ElectricalAppliance(){}

    public ElectricalAppliance(String type){
        this.type = type;
    }

    public ElectricalAppliance(String name, String type, double size, double documentedPower){
        this.name = name;
        this.type = type;
        this.size=size;
        this.documentedPower=documentedPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getDocumentedPower() {
        return documentedPower;
    }

    public void setDocumentedPower(double documentedPower) {
        this.documentedPower = documentedPower;
    }

    private void setConsumedPower(double consumedPower){
        this.consumedPower=consumedPower;
    }

    public double getConsumedPower() {
        return consumedPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElectricalAppliance that = (ElectricalAppliance) o;

        if (Double.compare(that.size, size) != 0) return false;
        if (Double.compare(that.documentedPower, documentedPower) != 0) return false;
        if (!name.equals(that.name)) return false;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + type.hashCode();
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(documentedPower);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ElectricalAppliance{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", documented power=" + documentedPower +
                '}';
    }

    public void turnOn(){
        setConsumedPower(getDocumentedPower());
    }

    public void turnOff(){
        setConsumedPower(0);
    }
}
