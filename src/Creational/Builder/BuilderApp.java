package Creational.Builder;

public class BuilderApp {


    public  static void main(String[] args) {
        User user = new User.Builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .city("New York")
                .active(true)
                .jobTitle("Software Engineer")
                .company("Tech Corp")
                .build();
        System.out.println("Kullanıcı oluşturuldu: " + user.toString());
    }
}
