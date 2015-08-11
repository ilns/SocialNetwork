package com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by volodymyr on 15/06/15.
 */
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_day")
    private Date birthDay;

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

    public Contact(String firstName, String lastName, Date birthDay) {
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
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
