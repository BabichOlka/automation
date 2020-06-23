package com.solvd.lab.automation.v2.mybatis.dao;
import com.solvd.lab.automation.v2.mybatis.model.Type;
import java.util.List;

public interface TypeDAO {
    void create(Type type);
    Type getById(int id);
    List<Type> get();
    void update(Type version);
    void delete(int id);
}
