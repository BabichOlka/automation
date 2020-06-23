package com.solvd.automation.lab.sql.dao;
import com.solvd.automation.lab.model.Engine;

import java.util.List;

public interface EngineDAO {
    void create(Engine engine);
    void update(Engine engine);
    void delete(Engine engine);

    Engine getById(int id);
    List<Engine> getAll();
}
