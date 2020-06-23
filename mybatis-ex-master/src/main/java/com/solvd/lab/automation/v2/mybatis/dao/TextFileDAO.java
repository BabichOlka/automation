package com.solvd.lab.automation.v2.mybatis.dao;


import com.solvd.lab.automation.v2.mybatis.model.TextFile;

import java.util.List;

public interface TextFileDAO {
    void create(TextFile textFile);
    TextFile getById(int id);
    List<TextFile> get();
    void update(TextFile textFile);
    void delete(int id);
}
