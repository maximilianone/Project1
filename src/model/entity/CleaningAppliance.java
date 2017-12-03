package model.entity;

public class CleaningAppliance extends ElectricalAppliance {
    public CleaningAppliance(){
        super( "Cleaning Appliance");
    }
    public CleaningAppliance(String name, double size, double documentedPower){
        super(name, "Cleaning Appliance", size, documentedPower);
    }
}
