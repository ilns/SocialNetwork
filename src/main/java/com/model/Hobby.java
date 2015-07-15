package com.model;

import javax.persistence.*;

/**
 * Created by volodymyr on 15/06/15.
 */

@Entity
@Table(name = "hobby")
public class Hobby {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id", unique = true, nullable = false)
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
