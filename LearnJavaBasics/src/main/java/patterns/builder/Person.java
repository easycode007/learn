package patterns.builder;

/**
 * Created by Razvan on 27.12.2016.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String address;
        private String phoneNumber;

        public Builder() { }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return firstName + ":" + lastName + ":" + address + ":" + phoneNumber;
    }
}

