package Structural.Facade;

public class Projector {
    public void turnOn() {
        System.out.println("Projector turned on.");
    }

    public void turnOff() {
        System.out.println("Projector turned off.");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to " + input + ".");
    }
}
