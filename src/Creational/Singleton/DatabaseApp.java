package Creational.Singleton;

public class DatabaseApp {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        databaseConnection.connect();
        System.out.println(databaseConnection.getDatabaseID());

        DatabaseConnection anotherConnection = DatabaseConnection.getInstance();
        anotherConnection.connect();
        System.out.println(databaseConnection.getDatabaseID());
    }
}
