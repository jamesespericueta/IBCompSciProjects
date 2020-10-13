package sample;

import java.io.Serializable;
import java.security.acl.LastOwnerException;

public class Student implements java.io.Serializable{
    private String firstname;
    private String lastName;
    private int age;
    private double gpa;
    private String username;
    private String password;

    public Student(String username, String password, String firstName, String lastName, int age, double gpa)
    {
        this.firstname = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gpa = gpa;
        this.username = username;
        this.password = password;
    }

    public String getFirstName ()
    {
        return firstname;
    }
    public String getLastName ()
    {
        return lastName;
    }
    public String getUsername()
    {
        return  username;
    }
    public String getPassword()
    {
        return password;
    }
    public int getAge ()
    {
        return age;
    }
    public double getGPA() {
        return gpa;
    }
}
