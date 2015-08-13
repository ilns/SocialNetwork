package com.logic.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "hobbies")
    private Set<Contact> contacts;

    public Hobby(){}

    public Hobby(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
