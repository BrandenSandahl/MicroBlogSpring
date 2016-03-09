package com.theironyard;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by branden on 3/7/16 at 13:10.
 *
 * See follow link for help with oneToMany and manyToOne
 * http://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/entity.html#entity-mapping-association
 */
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;

    @OneToMany
    @JoinColumn(name = "user_fk")
    private Set<Message> messageList;


    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set getMessageList() {
        return messageList;
    }

    public void setMessageList(Set messageList) {
        this.messageList = messageList;
    }
}