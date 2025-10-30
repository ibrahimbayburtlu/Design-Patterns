package Structural.Facade;

public class HomeTheaterFacade {
    private final AudioSystem audioSystem;
    private final VideoSystem videoSystem;
    private final Projector projector;

    public HomeTheaterFacade() {
        this.audioSystem = new AudioSystem();
        this.videoSystem = new VideoSystem();
        this.projector = new Projector();
    }

    public void watchMovie(String movie) {
        System.out.println("Getting ready to watch a movie: " + movie);
        projector.turnOn();
        projector.setInput("DVD Player");
        videoSystem.turnOn();
        videoSystem.setResolution("1080p");
        audioSystem.turnOn();
        audioSystem.setVolume(5);
        System.out.println("Enjoy your movie: " + movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater.");
        audioSystem.turnOff();
        videoSystem.turnOff();
        projector.turnOff();
    }
}
