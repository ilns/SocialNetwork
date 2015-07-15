package com.model;

import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by volodymyr on 15/06/15.
 */
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", unique = true, nullable = false)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private LocalDate birthDay;
//    private Set<Hobby> hobbies;
//    private Set<Place> places;
//    private Set<Contact> friends;
//
//    public Set<Contact> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(Set<Contact> friends) {
//        this.friends = friends;
//    }

    public Contact (){}

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Contact(String firstName, String lastName, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

//    public Set<Hobby> getHobbies() {
//        return hobbies;
//    }
//
//    public void setHobbies(Set<Hobby> hobbies) {
//        this.hobbies = hobbies;
//    }
//
//    public Set<Place> getPlaces() {
//        return places;
//    }
//
//    public void setPlaces(Set<Place> places) {
//        this.places = places;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
