package sample;

import java.util.Objects;

public class Accounts {
    private String username;
    private String password;
    private String lastName;

    public Accounts(String username, String password, String lastName)
    {
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public boolean equals(Accounts o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(username, o.username) &&
                Objects.equals(password, o.password) &&
                Objects.equals(lastName, o.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, lastName);
    }
}
