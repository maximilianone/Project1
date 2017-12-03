package model;

import model.entity.ElectricalAppliance;

import java.util.ArrayList;
import java.util.List;

public enum HomeAppliances {
    INSTANCE;

    private List<ElectricalAppliance> homeAppliances = new ArrayList<>();

    public void addAppliance(ElectricalAppliance appliance){
        homeAppliances.add(appliance);
    }

    public List<ElectricalAppliance> getAllAppliances(){
        return homeAppliances;
    }

    public void switchAppliances(boolean command, String... names){
        for (ElectricalAppliance appliance: homeAppliances){
            for(String name: names){
                if(appliance.getName().equals(name)){
                    if(command) {
                        appliance.turnOn();
                    }else{
                        appliance.turnOff();
                    }
                }
            }
        }
    }

    public double getPowerUsage(){
        double result=0;
        for(ElectricalAppliance appliance: homeAppliances){
            result+=appliance.getConsumedPower();
        }
        return result;
    }
}
