package Creational.Singleton;

public class DatabaseConnection {
    private double databaseID = Math.random();
    private static DatabaseConnection instance;

    DatabaseConnection(){

    }
    public void connect() {

        System.out.println("Veritabanına bağlanıldı.");
    }
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    public double getDatabaseID() {
        return databaseID;
    }
}
