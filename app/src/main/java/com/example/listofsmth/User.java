package com.example.listofsmth;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private String userName;
    private String userLastName;
    private UUID uuid;

    public User() {
        this(UUID.randomUUID()); //при создании нового
    }
    public User(UUID uuid){
        this.uuid = uuid; //при изменении существующего
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public UUID getUuid() {
        return uuid;
    }
}
