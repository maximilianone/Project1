package view;

import model.entity.ElectricalAppliance;

import java.util.List;

public class MenuView implements MenuConstants {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void showMenu() {
        displayMessage(ADD_APPLIANCE);
        displayMessage(TURN_ON_APPLIANCES);
        displayMessage(TURN_OFF_APPLIANCES);
        displayMessage(FIND_POWER);
        displayMessage(SORT_APPLIANCES);
        displayMessage(FIND_APPLIANCE);
        displayMessage(SHOW_ALL);
        displayMessage(EXIT);
    }

    public void showAddMenu() {
        displayMessage(KITCHEN);
        displayMessage(CLEANER);
        displayMessage(VIDEO);
        displayMessage(COMPUTER);
    }

    public void showAppliances(List<ElectricalAppliance> appliances) {
        for (ElectricalAppliance appliance : appliances) {
            System.out.println(appliance);
        }
    }
}
