package org.example.model;

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    private String email;

    public Person(int id ,String firstName, String lastName,String email) {
        this.id = id;
        setFirstname(firstName);
        setLastname(lastName);
        setEmail(email);


    }
    public int getId() {
        return id;
    }
    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("FirstName cannot be null");
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("LastName cannot be null");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email cannot be null");
        this.email = email;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
