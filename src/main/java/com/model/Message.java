package com.model;


import org.joda.time.LocalDate;

import javax.persistence.*;


/**
 * Created by volodymyr on 15/06/15.
 */
@Entity
@Table
public class Message {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "from")
    private Contact from;

    @Column(name = "to")
    private Contact to;

    @Column(name = "content")
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id", unique = true, nullable = false)
    private int id;

    public Message(){}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public Contact getTo() {
        return to;
    }

    public void setTo(Contact to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
