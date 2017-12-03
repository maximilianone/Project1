package service;

import model.entity.ElectricalAppliance;

import java.util.Comparator;

public class PowerComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2){
        ElectricalAppliance electricalAppliance1 = (ElectricalAppliance) o1;
        ElectricalAppliance electricalAppliance2 = (ElectricalAppliance) o2;
        return Double.compare(electricalAppliance1.getDocumentedPower(),electricalAppliance2.getDocumentedPower());
    }
}
