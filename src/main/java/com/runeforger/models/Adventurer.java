package com.runeforger.models;

import java.util.Date;

public class Adventurer {
    private Integer id;
    private String uuid;
    private String nick;
    private String display_nick;
    private String password;
    private String permission;
    private String email;
    private String data_creation;

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

    public String getDisplay_nick() {
        return display_nick;
    }

    public void setDisplay_nick(String display_nick) {
        this.display_nick = display_nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getData_creation() {
        return data_creation;
    }

    public void setData_creation(String data_creation) {
        this.data_creation = data_creation;
    }
}
