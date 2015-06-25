package com.model;

import org.springframework.stereotype.Component;

/**
 * Created by volodymyr on 15/06/15.
 */
// TODO FIX ME why market as Component ???
@Component
public class Hobby {
    private String title;
    private String description;

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
}
