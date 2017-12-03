package model.entity;

public class VideoAppliance extends ElectricalAppliance {
    public VideoAppliance(){
        super("Video Appliance");
    }
    public VideoAppliance(String name, double size, double documentedPower){
        super(name, "Video Appliance", size, documentedPower);
    }
}
