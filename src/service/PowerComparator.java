package service;

import model.entity.ElectricalAppliance;

import java.util.Comparator;

public class PowerComparator implements Comparator<ElectricalAppliance> {
    @Override
    public int compare(ElectricalAppliance electricalAppliance1, ElectricalAppliance electricalAppliance2){
        return Double.compare(electricalAppliance1.getDocumentedPower(),electricalAppliance2.getDocumentedPower());
    }
}
