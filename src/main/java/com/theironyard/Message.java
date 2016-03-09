package com.theironyard;

import javax.persistence.*;
import java.util.List;

/**
 * Created by branden on 3/7/16 at 13:22.
 */
@Entity
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_fk", insertable = false, updatable = false)
    private User user;



    public Message(String text) {
        this.text = text;
    }


    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}