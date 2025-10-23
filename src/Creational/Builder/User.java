package Creational.Builder;

public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String city;
    private final boolean active;
    private final String jobTitle;
    private final String company;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.city = builder.city;
        this.active = builder.active;
        this.jobTitle = builder.jobTitle;
        this.company = builder.company;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String city;
        private boolean active;
        private String jobTitle;
        private String company;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Builder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age + " (" + jobTitle + " at " + company + ")";
    }
}