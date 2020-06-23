package com.solvd.lab.automation.v2.mybatis.model;

import java.util.Date;

public class Version extends AbstractEntity {
    private String NameVersion;
    private Date date;

    public Version(String nameVersion, Date date) {
        NameVersion = nameVersion;
        this.date = date;
    }

    public Version() {
    }

    public String getNameVersion() {
        return NameVersion;
    }

    public void setNameVersion(String nameVersion) {
        NameVersion = nameVersion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
