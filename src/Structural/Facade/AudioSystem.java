package Structural.Facade;

public class AudioSystem {
    public void turnOn() {
        System.out.println("Audio system turned on.");
    }

    public void turnOff() {
        System.out.println("Audio system turned off.");
    }

    public void setVolume(int level) {
        System.out.println("Audio system volume set to " + level + ".");
    }
}
