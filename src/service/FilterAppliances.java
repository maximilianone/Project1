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
            if ((sizeBorders[0] <= appliance.getSize()) & (appliance.getSize() <= sizeBorders[1])) {
                if ((powerBorders[0] <= appliance.getDocumentedPower()) & (appliance.getDocumentedPower() <= powerBorders[1])) {
                    appliances.add(appliance);
                }
            }
        }
        return appliances;
    }
}
