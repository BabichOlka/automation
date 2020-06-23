package com.solvd.lab.automation.v2.mybatis.model;

public class Type extends AbstractEntity{
    private String nameType;

    public Type(String nameType) {
        this.nameType = nameType;
    }

    public Type() {
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
