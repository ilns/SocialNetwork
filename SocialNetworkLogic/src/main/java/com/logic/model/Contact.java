package com.logic.model;

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
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_day")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDay;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="Contact_hobbies",
            joinColumns={@JoinColumn(name = "Contact_id")},
            inverseJoinColumns={@JoinColumn(name="Hobby_id")})
    private Set<Hobby> hobbies;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Contact_places",
            joinColumns = {@JoinColumn(name= "Contact_id")},
            inverseJoinColumns = {@JoinColumn(name = "Place_id")})
    private Set<Place> places;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "List_friends",
            joinColumns = {@JoinColumn(name= "Contact_id_one")},
            inverseJoinColumns = {@JoinColumn(name = "Contact_id_two")})
    private Set<Contact> friends;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Contact_message",
            joinColumns = {@JoinColumn(name= "Contact_id")},
            inverseJoinColumns = {@JoinColumn(name = "Message_id")})
    private List<Message> messages;

    @ManyToMany(mappedBy = "friends", fetch = FetchType.EAGER)
    private Set<Contact> contactsFriends;


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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Set<Contact> getContactsFriends() {
        return contactsFriends;
    }

    public void setContactsFriends(Set<Contact> contactsFriends) {
        this.contactsFriends = contactsFriends;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public Set<Contact> getFriends() {
        return friends;
    }

    public void setFriends(Set<Contact> friends) {
        this.friends = friends;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
