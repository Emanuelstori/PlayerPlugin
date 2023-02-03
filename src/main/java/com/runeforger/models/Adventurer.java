package com.runeforger.models;

import java.util.Date;

public class Adventurer {
    private Integer id;
    private String uuid;
    private String nick;
    private String password;
    private String displayNick;
    private String permission;
    private String email;
    private Date createdAt;
    private AdventurerAttributes adventurerAttributes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayNick() {
        return displayNick;
    }

    public void setDisplayNick(String displayNick) {
        this.displayNick = displayNick;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AdventurerAttributes getAdventurerAttributes() {
        return adventurerAttributes;
    }

    public void setAdventurerAttributes(AdventurerAttributes adventurerAttributes) {
        this.adventurerAttributes = adventurerAttributes;
    }
}
