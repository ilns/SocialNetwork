package com.model;


import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;


/**
 * Created by volodymyr on 15/06/15.
 */

// TODO FIX ME why market as Component ???
@Service
public class Message {
    private LocalDate date;
    private Contact from;
    private Contact to;
    private String content;

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
}
