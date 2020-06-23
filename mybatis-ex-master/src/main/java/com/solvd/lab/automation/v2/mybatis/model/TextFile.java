package com.solvd.lab.automation.v2.mybatis.model;

import java.util.List;

public class TextFile extends AbstractEntity {
    private String nameFile;
    private String textFile;
    private List<Version> versions;
    private List<Type> types;

    public TextFile(String nameFile, String textFile) {
        this.nameFile = nameFile;
        this.textFile = textFile;
    }

    public TextFile(String nameFile, String textFile, List<Version> versions, List<Type> types) {
        this.nameFile = nameFile;
        this.textFile = textFile;
        this.versions = versions;
        this.types = types;
    }

    public TextFile() {
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getTextFile() {
        return textFile;
    }

    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
