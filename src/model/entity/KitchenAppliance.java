package model.entity;

public class KitchenAppliance extends ElectricalAppliance {
    public KitchenAppliance(){
        super("Kitchen Appliance");
    }
    public KitchenAppliance(String name, double size, double documentedPower){
        super(name, "Kitchen Appliance", size, documentedPower);
    }

}
