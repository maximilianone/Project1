package model.entity;

public class ComputerAppliance extends ElectricalAppliance{
    public ComputerAppliance(){
        super("Computer Appliance");
    }
    public ComputerAppliance(String name, double size, double documentedPower){
        super(name, "Computer Appliance", size, documentedPower);
    }
}
