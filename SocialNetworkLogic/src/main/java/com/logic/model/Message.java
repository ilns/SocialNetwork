package com.logic.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by volodymyr on 15/06/15.
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "fromContact")
    private Contact fromContact;

    @Column(name = "toContact")
    private Contact toContact;

    @Column(name = "content")
    private String content;


    public Message(){}

    public Message(Contact from, Contact to, String content){
        this.fromContact = from;
        this.toContact = to;
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Contact getFromContact() {
        return fromContact;
    }

    public void setFromContact(Contact fromContact) {
        this.fromContact = fromContact;
    }

    public Contact getToContact() {
        return toContact;
    }

    public void setToContact(Contact toContact) {
        this.toContact = toContact;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
