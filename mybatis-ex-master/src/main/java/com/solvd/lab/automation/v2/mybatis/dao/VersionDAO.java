package com.solvd.lab.automation.v2.mybatis.dao;


import com.solvd.lab.automation.v2.mybatis.model.Version;

import java.util.List;

public interface VersionDAO {
    void create(Version version);
    Version getById(int id);
    List<Version> get();
    void update(Version version);
    void delete(int id);
}
