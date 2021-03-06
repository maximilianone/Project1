package controll;

import model.HomeAppliances;
import model.entity.ElectricalAppliance;

import java.io.*;
import java.util.List;

public class FileController {
    private String address = "homeAppliances.ser";

    void saveToFile(List<ElectricalAppliance> homeAppliances) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(address))) {
            for (ElectricalAppliance appliance : homeAppliances) {
                out.writeObject(appliance);
            }
            out.writeObject(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadFile(HomeAppliances homeAppliances) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(address))) {
                for (Object appliance; (appliance = in.readObject()) instanceof ElectricalAppliance; ) {
                    homeAppliances.addAppliance((ElectricalAppliance) appliance);
                }
            }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
