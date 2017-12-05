package service;

import model.HomeAppliances;
import model.entity.ElectricalAppliance;

import java.util.ArrayList;
import java.util.List;

public class FilterAppliances {
    public List<ElectricalAppliance> findAppliance(double[] sizeBorders, double[] powerBorders,
                                                   HomeAppliances homeAppliances) {
        List<ElectricalAppliance> appliances = new ArrayList<>();
        for (ElectricalAppliance appliance : homeAppliances.getAllAppliances()) {
            if (hasSizeBetween(sizeBorders, appliance)) {
                if (hasPowerBetween(powerBorders, appliance)) {
                    appliances.add(appliance);
                }
            }
        }
        return appliances;
    }

    private boolean hasSizeBetween(double[] sizeBorders, ElectricalAppliance appliance){
        return ((sizeBorders[0] <= appliance.getSize()) & (appliance.getSize() <= sizeBorders[1]));
    }

    private boolean hasPowerBetween(double[] powerBorders, ElectricalAppliance appliance){
        return ((powerBorders[0] <= appliance.getDocumentedPower()) & (appliance.getDocumentedPower() <= powerBorders[1]));
    }
}
