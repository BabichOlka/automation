package com.solvd.automation.classes.c15;

public class UserInfo {

    private String id;
    private String name;
    private String password;

    public UserInfo(){}

    public UserInfo(String id){
        this.id = id;
    }
    public UserInfo(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}