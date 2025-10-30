package Structural.Facade;

public class VideoSystem {
    public void turnOn() {
        System.out.println("Video system turned on.");
    }

    public void turnOff() {
        System.out.println("Video system turned off.");
    }

    public void setResolution(String resolution) {
        System.out.println("Video system resolution set to " + resolution + ".");
    }
}
