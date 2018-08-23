package com.ytb.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;


    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;


    public long getId() {
        return id;
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
