package service;

import model.HomeAppliances;
import model.Range;
import model.entity.ElectricalAppliance;

import java.util.ArrayList;
import java.util.List;

public class FilterAppliances {
    public List<ElectricalAppliance> findAppliance(Range sizeBorders, Range powerBorders,
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

    private boolean hasSizeBetween(Range sizeBorders, ElectricalAppliance appliance) {
        return ((sizeBorders.getLeft() <= appliance.getSize()) & (appliance.getSize() <= sizeBorders.getRight()));
    }

    private boolean hasPowerBetween(Range powerBorders, ElectricalAppliance appliance) {
        return ((powerBorders.getLeft() <= appliance.getDocumentedPower()) & (appliance.getDocumentedPower() <= powerBorders.getRight()));
    }
}
